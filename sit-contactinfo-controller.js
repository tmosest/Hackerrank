
/* JavaScript content from app/js/secured/preferences/contactinfo/contact-preferences.controller.js in folder common */
(function () {
    'use strict';

    angular
        .module('app.preferences')
        .controller('PreferencesContactInfoController', PreferencesContactInfoController);

    PreferencesContactInfoController.$inject = ['messages', '$log', '$timeout', '$window', 'appConfig',
                                                'DialogBoxService', 'PreferencesService', 'PreferencesStaticService',
                                                'NotificationService', '$scope', '$state', 'LoadingService',
                                                'ProfileService', 'PreferencesCenterAnalyticsService'];

    function PreferencesContactInfoController(messages, $log, $timeout, $window,
                                                appConfig, DialogBoxService,
                                                PreferencesService, PreferencesStaticService,
                                                NotificationService, $scope, $state, LoadingService, ProfileService,
                                              PreferencesCenterAnalyticsService) {
        var vm = this;
        vm.messages = messages;

        vm.onClickOtherUpdates = function () {
            $state.go('profile.memberinfo-how');
        };

        vm.handleContactInfoSubmit = function (isValid) {
            if (!isValid) {
                return;
            }
            var isEdited = vm.isContactInfoEdited();
            if (!isEdited) {
                return;
            }
            if (vm.contactInfoData.isTextNumberDeleted) {
                //Show Stop Text Disclaimer
                PreferencesStaticService.openDialog('STOPTEXT', continueSave,
                                                    function () {});
            } else {
                continueSave();
            }
        };

        function continueSave() {
            var saveObj = {};
            var telephoneNum = '';
            var textNumformated = '';
            if (vm.prefferedPhoneNum && vm.prefferedPhoneNum.value) {
                telephoneNum = vm.prefferedPhoneNum.value;
            }
            if (vm.phoneNumber && (vm.phoneNumber.length > 10) && (vm.phoneNumber[0] === '1')) {
                textNumformated = vm.phoneNumber.substring(1, 11);
            }

            saveObj = {
                updateEmailRequest: {
                    emailUId: vm.contactInfo.emailUID,
                    emailAddress: vm.emailDetailsTxt,
                    isNewEmail: vm.isEmailNewlyAdded ? true : false
                },
                updateTextNumberRequest: {
                    textNumberUId: vm.contactInfo.textNumberUId,
                    deviceNumber: textNumformated !== '' ? textNumformated : vm.phoneNumber,
                    isNewTextNumber: vm.contactInfoData.isFirstTimeTextNumber ? true : false,
                    isDeleteTextNumber: vm.contactInfoData.isTextNumberDeleted ? true : false
                },
                updatePhoneRequest: {
                    telephoneUId: telephoneNum,
                },
                updatePersonalPreferenceRequest: {
                    preferenceCode: vm.selectedLanguage.value,
                    preferenceName: vm.selectedLanguage.display,
                    preferenceUId: vm.contactInfo.originalResponse.personalPreferenceResponse.preferenceUId
                }
            };
            if (!vm.contactInfoData.isReadonlyAddress && vm.isNewVoiceNumAdded) {
                saveObj.addPhoneRequest = {
                    phoneNumber: vm.newVoiceNumber.replace(/[^0-9]+/g, '')
                };
            }
            if (!vm.contactInfoData.isReadonlyAddress && vm.isAddressEdited()) {
                saveObj.updateAddressRequest = {
                    addressLine1: vm.addressObj.addressLineOne,
                    addressLine2: vm.addressObj.addressLineTwo,
                    city:  vm.addressObj.city,
                    state: vm.addressObj.stateCode,
                    postalCode: vm.addressObj.postalCode
                };
            }
            LoadingService.show();
            //Save Preferences
            PreferencesService.saveContactInfoPreferences(saveObj).then(function (resp) {
                if (resp.error === false) {
                    vm.contactInfoData.doubleConfirm = false;
                    if (vm.contactInfoData.isLanguageOptionChanged) {
                        PreferencesCenterAnalyticsService.onChangepreferedLanguage(vm.selectedLanguage.display);
                    }

                    //Newly added or Modified Text Number Scenario
                    if (vm.contactInfoData.isTextNumberModified || vm.contactInfoData.isFirstTimeTextNumber) {
                        LoadingService.hide();
                        NotificationService.showPageAlert({
                            title: vm.messages.PREFERENCES_TEXT_NUMBER_NEW_MODIFIED_TITLE,
                            message: vm.messages.PREFERENCES_TEXT_NUMBER_NEW_MODIFIED_MESSAGE,
                            isStackedAlert: vm.contactInfoData.isReadonlyAddress ?  false : true
                        });
                        window.scrollTo(0, 0);
                    } else if (vm.contactInfoData.isTextNumberDeleted) { //Deleted Text Number Scenario
                        $window.history.go(-1);
                        $timeout(function () {
                            LoadingService.hide();
                            NotificationService.showPageAlert({
                                title: vm.messages.PREFERENCES_TEXT_NUMBER_DELETE_TITLE,
                                messageLink: vm.messages.PREFERENCES_TEXT_NUMBER_DELETE_LINK,
                                message: vm.messages.PREFERENCES_TEXT_NUMBER_DELETE_MESSAGE,
                                isStackedAlert: vm.contactInfoData.isReadonlyAddress ? false : true
                            });
                        }, 1000);
                    } else {
                        LoadingService.hide();
                        //generic save pagelevel alert(other than Text Number scenarios)
                        if (!vm.contactInfoData.isReadonlyAddress && vm.isAddressEdited()) {
                            NotificationService.showPageAlert({
                                title: vm.messages.PREFERENCES_CONTACTINF_ADDRESS_SAVED_TITLE,
                                message: vm.messages.PREFERENCES_CONTACTINF_ADDRESS_SAVED_MESSAGE
                            });
                        } else {
                            NotificationService.showPageAlert({
                                title: vm.messages.PREFERENCES_ACCOUNT_SETTINGS_SAVED_TITLE,
                                message: vm.messages.PREFERENCES_ACCOUNT_SETTINGS_SAVED_MESSAGE
                            });
                        }
                        window.scrollTo(0, 0);
                    }
                }
            }).catch(function () {
                LoadingService.hide();
                DialogBoxService.alert({
                    title: messages.SERVER_GENERIC_ERROR_TITLE,
                    message: messages.SERVER_GENERIC_ERROR_MESSAGE
                });
            }).finally(function () {
                LoadingService.hide();
            });
        }
        $scope.$on('MessagelinkClicked', function () {
            $state.go('preferences.contactinfo');
        });

        $scope.$on('stackedAlerts', function () {
            $timeout(function () {
                NotificationService.showPageAlert({
                    title: vm.messages.PREFERENCES_CONTACTINF_ADDRESS_SAVED_TITLE,
                    message: vm.messages.PREFERENCES_CONTACTINF_ADDRESS_SAVED_MESSAGE
                });
            }, 1000);
        });
        vm.isContactInfoEdited = function () {
            if (vm.emailDetailsTxt !== vm.contactInfo.emailAddress) {
                vm.contactInfoData.isEmailModified = true;
                vm.isEmailModified = true;
                if (vm.contactInfo.emailAddress === null) {
                    vm.isEmailNewlyAdded = true;
                }
            }

            if ((vm.contactInfo.textNumber !== undefined) &&
                (vm.contactInfo.textNumber !== '') &&
                (vm.contactInfo.textNumber !== null)) {
                if ((vm.phoneNumber !== vm.contactInfo.textNumber) &&
                    (vm.contactInfoData.isDeclinedScenario === false)) {
                    vm.contactInfoData.isTextNumberModified = true;
                    vm.contactInfoData.doubleConfirm = false;
                    if ((vm.phoneNumber === '') &&
                        (vm.contactInfoData.isDeclinedScenario === false) &&
                        (vm.contactInfoData.doubleConfirm === false)) {
                        vm.contactInfoData.isTextNumberModified = false;
                        vm.contactInfoData.isTextNumberDeleted = true;
                    }
                }
            } else {
                if ((vm.phoneNumber !== '') &&
                    (vm.phoneNumber !== null) &&
                    (vm.contactInfoData.isDeclinedScenario === false) &&
                    (vm.contactInfoData.doubleConfirm === false)) {
                    vm.contactInfoData.isFirstTimeTextNumber = true;
                }
            }

            if (vm.prefferedPhoneNum && vm.oldPrefferedPhoneNum &&
               (vm.prefferedPhoneNum.display !== vm.oldPrefferedPhoneNum.display)) {
                vm.contactInfoData.isVoicePhoneChanged = true;
            }
            
            if(vm.selectedLanguage.value !== vm.oldSelectedLanguage.value){
                vm.contactInfoData.isLanguageOptionChanged = true;
            }
            //is Address Modified
            if (vm.contactInfoData.isReadonlyAddress === false) {
                if ((vm.addressObj.addressLineOne !== vm.address.addressLineOne) ||
                     (vm.addressObj.addressLineTwo !== vm.address.addressLineTwo) ||
                     (vm.addressObj.city !== vm.address.city) ||
                     (vm.addressObj.postalCode !== vm.address.postalCode) ||
                        vm.selectedstate !== vm.address.stateCode) {
                    vm.isAddressModified = true;
                } else {
                    vm.isAddressModified = false;
                }

                if (vm.newVoiceNumber !== '') {
                    vm.isNewVoiceNumAdded = true;
                }
            }
            if (vm.contactInfoData.isTextNumberDeleted || vm.contactInfoData.isEmailModified ||
               vm.contactInfoData.isTextNumberModified || vm.contactInfoData.isVoicePhoneChanged ||
               vm.contactInfoData.isLanguageOptionChanged || vm.contactInfoData.isFirstTimeTextNumber ||
               vm.isAddressModified || vm.isNewVoiceNumAdded) {
                return true;
            } else {
                return false;
            }
        };

        vm.isAddressEdited = function () {
            if ((vm.addressObj.addressLineOne !== vm.address.addressLineOne) ||
                    (vm.addressObj.addressLineTwo !== vm.address.addressLineTwo) ||
                    (vm.addressObj.city !== vm.address.city) ||
                    (vm.addressObj.postalCode !== vm.address.postalCode) ||
                    vm.selectedstate !== vm.address.stateCode) {
                vm.isAddressModified = true;
            } else {
                vm.isAddressModified = false;
            }
            return vm.isAddressModified;
        };

        vm.onCancel = function () {
            if (vm.isContactInfoEdited() === true) {
                DialogBoxService.confirm({
                    message: vm.messages.PROFILE_CANCEL,
                    buttons: {
                        main: vm.messages.PROFILE_CANCEL_CONTINUE,
                        alternate: vm.messages.PROFILE_CANCEL_BACK
                    }
                }).then(function (isOkPressed) {
                    if (isOkPressed) {
                        $window.history.go(-1);
                    }
                });
            } else {
                $window.history.go(-1);
            }
        };

        phoneTxtListener();

        function phoneTxtListener() {
            $timeout(function () {
                angular.element(document).find('.phonenumber').on('focus', function () {
                    vm.phonetxtNotifyDialog();
                });
            }, 300);
        }

        vm.phonetxtNotifyDialog = function () {
            if (!vm.setFocus) {
                PreferencesStaticService.openDialog('TEXT', agreeTxtMessage,
                    disagreeTxtMessage);
            }
        };

        vm.stateSelected = function () {
            vm.selectedstate = vm.stateValue.value;
        };

        function agreeTxtMessage() {
            var phoneNumTextbox = angular.element(document).find('.phonenumber');
            vm.setFocus = true;
            $timeout(function () {
                phoneNumTextbox.focus();
                vm.setFocus = false;
            }, 200);
        }

        function disagreeTxtMessage() {
            vm.setFocus = false;
            return;
        }

        function createStateList(stateList) {
            vm.stateOptions = {
                options: []
            };
            var options = [];
            for (var x = 0; x < stateList.length; x++) {
                options.push({
                    value: stateList[x],
                    display: stateList[x]
                });
            }
            vm.stateOptions.options = options;
            if (vm.form && vm.form.state) {
                vm.stateValue = _.findWhere(vm.stateOptions.options, {
                    display: vm.address.stateCode
                });
            }
        }

        activate();
        function activate() {
            vm.contactInfoData = {
                doubleConfirm: false,
                isFirstTimeTextNumber: false,
                isTextNumberDeleted: false,
                isEmailModified: false,
                isTextNumberModified: false,
                isVoicePhoneChanged: false,
                isLanguageOptionChanged: false,
                isDeclinedScenario: false,
                setFocus: false,
                isReadonlyAddress: true,
                supportedLanguages: [
                    {display: 'English', value: '100'},
                    {display: 'Korean', value: '100215'},
                    {display: 'Mandarin', value: '100454'},
                    {display: 'Spanish', value: '300'},
                    {display: 'Tagalog', value: '100387'},
                    {display: 'Vietnamese', value: '100424'}
                ]
            };
            vm.addressObj = {};
            var defaultPhNum;
            PreferencesCenterAnalyticsService.onLoadContactInfo();
            vm.brand = appConfig.brandInfo.brandShortName;
            LoadingService.show();
            PreferencesService.getContactInfoPreferences(true).then(function (response) {
                if (response.error === false) {
                    vm.contactInfo = response;
                    if (vm.contactInfo.addressDetailsResponse &&
                        angular.isDefined(vm.contactInfo.addressDetailsResponse.readOnlyAddressPhone)) {
                        vm.contactInfoData.isReadonlyAddress =
                            vm.contactInfo.addressDetailsResponse.readOnlyAddressPhone;
                    }
                    if (vm.contactInfoData.isReadonlyAddress === false) {
                        ProfileService.getStates().then(function (states) {
                            createStateList(states);
                            LoadingService.hide();
                        }).catch(function () {
                            LoadingService.hide();
                            DialogBoxService.alert({
                                title: vm.messages.SERVER_GENERIC_ERROR_TITLE,
                                message: vm.messages.SERVER_GENERIC_ERROR_MESSAGE
                            });
                        }).finally(function () {
                            LoadingService.hide();
                        });
                    }
                    if (angular.isDefined(vm.contactInfo.addressDetailsResponse)) {
                        vm.address = vm.contactInfo.addressDetailsResponse;
                        vm.addressObj.addressLineOne =  vm.address.addressLineOne;
                        vm.addressObj.addressLineTwo =  vm.address.addressLineTwo;
                        vm.addressObj.city =  vm.address.city;
                        vm.addressObj.postalCode =  vm.address.postalCode;
                        vm.noAddress = false;
                    } else {
                        vm.noAddress = true;
                    }
                    vm.registeredPhoneNumbers = vm.contactInfo.voiceNumbers;
                    vm.emailDetailsTxt = vm.contactInfo.emailAddress;
                    vm.phoneNumber = vm.contactInfo.textNumber;
                    //token expired
                    if (vm.contactInfo.deviceStatus === 'EXPD') {
                        vm.contactInfoData.doubleConfirm  = true;
                    } else if (vm.contactInfo.deviceStatus === 'DCLND') {
                        //'its declined scenatio. Dont show delete message
                        vm.contactInfoData.isDeclinedScenario = true;
                        vm.phoneNumber = '';
                    }

                    if (angular.isArray(vm.contactInfo.voiceNumber) && vm.contactInfo.voiceNumber.length === 1 &&
                        (vm.contactInfoData.isReadonlyAddress)) {
                        vm.maskedVoiceNum = vm.contactInfo.voiceNumber[0].slice(-4);
                    } else {
                        vm.phoneList = {
                            options: []
                        };
                        var options = [];
                        var preferedIndex = -1;
                        for (var index = 0; index < vm.registeredPhoneNumbers.length; index++) {
                            var formatedNum = vm.registeredPhoneNumbers[index].phoneNbr.substr(0, 3) + '-' +
                                           vm.registeredPhoneNumbers[index].phoneNbr.substr(3, 3) + '-' +
                                           vm.registeredPhoneNumbers[index].phoneNbr.substr(6, 4);
                            if (vm.registeredPhoneNumbers[index].preferred === true) {
                                preferedIndex = index;
                            }
                            options.push({
                                value: vm.registeredPhoneNumbers[index].telephoneUId,
                                display: formatedNum
                            });
                        }

                        vm.phoneList.options = options;
                        if (preferedIndex === -1) {
                            var isHomeDefault = _.findWhere(vm.registeredPhoneNumbers,
                                                            {phoneType: 'HOME'});
                            if (isHomeDefault !== undefined) {
                                isHomeDefault.preferred = true;
                                defaultPhNum =  _.findWhere(vm.phoneList.options,
                                                            {value: isHomeDefault.phoneNbr});
                            } else {
                                var isPersonalDefault = _.findWhere(vm.registeredPhoneNumbers,
                                                                    {phoneType: 'PERSONAL'});
                                if (isPersonalDefault !== undefined) {
                                    isPersonalDefault.preferred = true;
                                    defaultPhNum =  _.findWhere(vm.phoneList.options,
                                                                {value: isHomeDefault.phoneNbr});
                                } else {
                                    var isCellDefault = _.findWhere(vm.registeredPhoneNumbers,
                                        {phoneType: 'CELL'});
                                    if (isCellDefault !== undefined) {
                                        isCellDefault.preferred = true;
                                        defaultPhNum =  _.findWhere(vm.phoneList.options,
                                                                    {value: isHomeDefault.phoneNbr});
                                    }
                                }
                            }
                            vm.prefferedPhoneNum = defaultPhNum;
                            vm.oldPrefferedPhoneNum = defaultPhNum;
                        } else {
                            vm.prefferedPhoneNum = vm.phoneList.options[preferedIndex];
                            vm.oldPrefferedPhoneNum = vm.phoneList.options[preferedIndex];
                        }
                    }
                    vm.prefferedLangCode = vm.contactInfo.originalResponse.personalPreferenceResponse.preferenceCode;

                    var prefLanguage = _.findWhere(vm.contactInfoData.supportedLanguages,
                        {value: vm.prefferedLangCode});
                    vm.selectedLanguage = prefLanguage;
                    vm.oldSelectedLanguage = prefLanguage;
                    LoadingService.hide();
                }
            }).catch(function () {
                DialogBoxService.alert({
                    title: messages.SERVER_GENERIC_ERROR_TITLE,
                    message: messages.SERVER_GENERIC_ERROR_MESSAGE
                });
            }).finally(function () {
                LoadingService.hide();
            });
        }
    }
})();

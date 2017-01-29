process.stdin.resume();
process.stdin.setEncoding('ascii');

var input_stdin = "";
var input_stdin_array = "";
var input_currentline = 0;

process.stdin.on('data', function (data) {
    input_stdin += data;
});

process.stdin.on('end', function () {
    input_stdin_array = input_stdin.split("\n");
    main();    
});

function readLine() {
    return input_stdin_array[input_currentline++];
}

/////////////// ignore above this line ////////////////////
var debugMode = false;

function main() {
	var temp = readLine().split(' ');
	var n = parseInt(temp[0]);
	var k = parseInt(temp[1]);
    arr = readLine().split(' ');
    arr = arr.map(Number);
    var charged = parseInt(readLine());
    if(debugMode)
    	console.log('n: ' + n + ' k: ' + k + ' charged: ' + charged);
    var totalShared = 0;
    for(var i = 0; i < arr.length; i++) {
    	if(i != k) {
    		totalShared += arr[i];
    	}
    }
    totalShared /= 2;
    if(debugMode)
    	console.log('totalShared: ' + totalShared);
    if(totalShared == charged)
    	console.log("Bon Appetit");
    else 
    	console.log(charged - totalShared);
}

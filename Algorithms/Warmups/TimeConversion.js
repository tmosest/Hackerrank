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
function convertTimeToMilitary(time)
{
	// Get PM or AM
	var xm = time.substring(8, 10);
	var hours = time.substring(0, 2);
	var remainder = time.substring(2, 8);
	//console.log(remainder);
	if(xm == 'AM') {
		if(hours == 12) {
			hours = '00';
		}
		time = hours + remainder;
	} else {
		if(hours != 12) {
			hours = Number(hours) + 12;
		}
		time = hours + remainder;
	}
	return time;
}

function main() {
    var time = readLine();
    console.log(convertTimeToMilitary(time));
}

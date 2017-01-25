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

function main() {
    var arr = readLine().split(' ').map(Number);
    var max = 0;
    var min = 0;
    for(var i = 0; i < arr.length; i++){
    	min += arr[i];
    }
    for(var i = 0; i < arr.length; i++) {
    	var sum = 0;
    	for(var j = 0; j < arr.length; j++) {
    		if(i != j) {
    			sum += arr[j];
    		}
    	}
    	min = Math.min(min, sum);
    	max = Math.max(max, sum);
    }
    console.log(min + ' ' + max);
}

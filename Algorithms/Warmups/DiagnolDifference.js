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

function computeDiagnolDifference(matrix)
{
	var n = matrix.length;
	
	var downRight = 0;
	for(var i = 0; i < n; i++) {
		downRight += matrix[i][i];
	}
	
	var downLeft = 0;
	for(var i = 0; i < n; i++) {
		downLeft += matrix[i][n - i - 1];
	}
	return Math.abs(downRight - downLeft);
}

function main() {
    var n = parseInt(readLine());
    var a = [];
    for(a_i = 0; a_i < n; a_i++){
       a[a_i] = readLine().split(' ');
       a[a_i] = a[a_i].map(Number);
    }
    console.log(computeDiagnolDifference(a));
}
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
class Kangaroo {
	constructor(position, velocity) {
		this.position = position;
	    this.velocity = velocity;
	}
}

function willSecondKangarooCathchFirst(k1, k2)
{
	var i = (k1.position - k2.position) / (k2.velocity - k1.velocity);
	
	if(i > 0 && i == Math.floor(i)) {
		console.log("YES");
		return;
	}
	console.log("NO");
}

function main() {
    var x1_temp = readLine().split(' ');
    var x1 = parseInt(x1_temp[0]);
    var v1 = parseInt(x1_temp[1]);
    var x2 = parseInt(x1_temp[2]);
    var v2 = parseInt(x1_temp[3]);
    var k1 = new Kangaroo(x1, v1);
    var k2 = new Kangaroo(x2, v2);
    willSecondKangarooCathchFirst(k1, k2);
}

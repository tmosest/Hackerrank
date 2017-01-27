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
    h = readLine().split(' ');
    h = h.map(Number);
    var word = readLine();
    
    var max = 0;
    for(var i = 0; i < word.length; i++) {
    	var letter = word.charAt(i).charCodeAt() - 'a'.charCodeAt();
    	if(debugMode)
    		console.log(letter);
    	max = Math.max(max, h[letter]);
    }
    console.log(word.length * max);
}

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
    var n = parseInt(readLine());
    c = readLine().split(' ');
    c = c.map(Number);
    //Sort the array
    c.sort();
    var pairs = 0;
    var pair_holder = 1;
    var holder = c[0];
    
    for(var i = 1; i < n; i++) {
    	if(c[i] == holder) {
    		pair_holder++;
    	} else {
    		pair_holder = 1;
    	}
    	holder = c[i];
        if(pair_holder == 2) {
            pairs++;
            pair_holder = 1;
            holder = -1000;
        }
    }
    
    console.log(pairs);
}

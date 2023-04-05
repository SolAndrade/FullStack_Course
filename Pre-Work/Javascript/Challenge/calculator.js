function appendToOutput(value) {
    document.getElementById("output").value += value;
}

function clearOutput() {
    document.getElementById("output").value = "";
}

function backspaceOutput() {
    var output = document.getElementById("output");
    output.value = output.value.slice(0, -1);
}

function calculateOutput() {
    var output = document.getElementById("output");
    var result = eval(output.value);
    output.value = result;
}
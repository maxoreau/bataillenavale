/**
 * 
 */
function Player(id, name, nbWins) {
    this.id = id;
    this.name = name;
    this.nbWins = nbWins;
}

var stompClient = null;
var playerName;

function connect() {
    var player = new Player(0, $("#name").val(), 0);
    var socket = new SockJS('/battleship-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function(frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/connected', function(greeting) {
            showConnectedPlayer(JSON.parse(greeting.body).name);
        });

        stompClient.send("/app/connect", {}, player.name);
    });
}

function setConnected(connected) {
    if (connected) {
        $("#connect").hide();
        $("#loginForm").hide();
        $("#disconnect").show();
        $("#description").show();

    } else {
        $("#disconnect").hide();
        $("#connect").show();
        $("#description").hide();
        $("#loginForm").show();
        $("#playGround").hide();
        setInGame(false);
    }
}

function setInGame(inGame) {
    if (inGame) {
        $("#playGround").show();
    } else {
        $("#playGround").hide();
    }
}


function disconnect() {
    if (stompClient != null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {}

function showConnectedPlayer(message) {
    $("#players").append("<tr><td>Hello " + message + "</td></tr>");
}

$(function() {
    $("form").on('submit', function(e) {
        e.preventDefault();
    });
});

setConnected(false);

$('#connect').click(function() {
    console.log($("#name").val());
    connect();
})

$('#disconnect').click(function() {
    disconnect();
})

$('#joinGame').click(function() {
    setInGame(true);
})

$('#showOpenGames').click(function() {})
/**
 * 
 */
var stompClient = null;
var playerName

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    var socket = new SockJS('/battleship-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/greetings', function (greeting) {
            showGreeting(JSON.parse(greeting.body).content);
        });
    });
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

function sendName() {
    stompClient.send("/app/hello", {}, JSON.stringify({ 'name': $("#name").val() }));
}

function showGreeting(message) {
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $("#connect").click(function () { connect(); });
    $("#disconnect").click(function () { disconnect(); });
    $("#send").click(function () { sendName(); });
});




// ------------- partie REST définie précédemment ------------------------//


function Player(id, name, nbWins) {
    this.id = id;
    this.name = name;
    this.nbWins = nbwins;
}

$('#showPlayersBtn').click(function () {
    console.log("click");
    fetchAllPlayers();
})

function fetchAllPlayers() {
    var url = ('http://localhost:8080/battleship/players');
    $.getJSON(url, function (players) {
        console.log(players);
        fillDivShowPlayers(players)
    });

}

function fillDivShowPlayers(contacts) { // affichage des contacts dans une liste à puces
    $('#showPlayers').html(''); // vide la liste à puces avant de la remplir.
    var innerTable = '<tr><th></th><th>Player name</th></tr>';
    $(innerTable).appendTo($('#checkboxes'));

    if (players.length == 0) {
        $('#showPlayers').hide();
    } else {
        players.forEach(function (player) { // itérer sur la collection pour remplir compléter le html
            //  générant la liste à puces
            var line = '<tr>';
            line += ('<td><input type="checkbox" value="' + player.id + '"/></td>');
            line += ('<td>' + player.name + '</td>');
            line += '</tr>';
            $(line).appendTo($('#showPlayers'));
        }, this);
        $('</table>').appendTo($('#showPlayers'));
    }
}

var div = "showPlayers";







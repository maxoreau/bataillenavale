/**
 * 
 */
function Player(id, name, nbWins) {
    this.id = id;
    this.name = name;
    this.nbWins = nbwins;
}
console.log("bordel de merde!");

$('#showPlayersBtn').click(function() {
    console.log("click");
    fetchAllPlayers();    
})

function fetchAllPlayers () {
    var url = ('http://localhost:8080/battleship/players');
    $.getJSON(url, function(players) {
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
        players.forEach(function(player) { // itérer sur la collection pour remplir compléter le html
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







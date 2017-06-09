
$(document).ready(function () {
    // $('#myBtn').click(function() {
    //     getText();
    // });
    $('#myBtn').click(getText);
    $('#myBtn2').click(handleEvent);
    $('#myBtn3').click(handleJackson);
    $('#pokeBtn').click(handlePoke);

    $('#pokeNum').keydown(function(e) {
        if (e.keyCode === 13) {
            handlePoke();
        }
    });


    $('#sound').hide();

    $('#chicken').mousedown(function() {
        $('#sound').show();
    }).mouseup(function() {
        $('#sound').hide();
    });
});

function getText() {
    // var xhr = new XMLHttpRequest();
    // xhr.onreadystatechange = function() {
    //     if (xhr.readyState === 4 && xhr.status === 200) {
    //         document.getElementById("stuff").innerHTML = this.responseText;
    //     }
    // };
    //
    //
    // xhr.open("GET", "/GetText", true);
    // xhr.send();


    $.ajax({ url: "/GetText", })
        .done(function( data ) {
            $('#stuff').html(data);
        });
}

var myPerson;
function handleEvent() {
    $.ajax({ url: "/GetJson", })
        .done(function( data ) {
            myPerson = data;
            // myPerson = JSON.parse(data);
            $('#stuff').html(myPerson.name + '(' + myPerson.age + ')');
        });
}

function handleJackson() {
    $.ajax({
        url:"/GetJacksonJson",
        method:"GET",
        success: function(res, status, xhr) {
            myPerson = res;
            $('#stuff').html(myPerson.name + ' [' + myPerson.age + ']');
        },
        error: function(xhr, status) {
            console.log('ERROR OCURED');
        },
        complete: function(xhr, status) {
            console.log('completeeed');
        }
    });
}

function handlePoke() {
    var num = $('#pokeNum').val();
    // $('#pokeNum').val('');

    $.ajax({
        url:"http://pokeapi.co/api/v2/pokemon/"+num+"/",
        method:"GET",
        success: function(res, status, xhr) {
            console.log(res);
            $('#stuff').html(res.name);

            $('#sound').html(res.types[0].type.name);
            $('#sound').css('color', getRandomColor());

            $('#chickPic').attr('src', res.sprites.front_default);
            $('#bigChickPic').attr('src', res.sprites.front_shiny);
        }
    });
}

function getRandomColor() {
    var letters = '0123456789ABCDEF'.split('');
    var color = '#';

    for (var i = 0; i < 6; i++ ) {
        color += letters[Math.floor(Math.random() * 16)];
    }

    return color;
}
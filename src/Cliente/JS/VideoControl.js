$(document).ready(function () {
    $("#askVideo").on("click", function () {
        var token = "003f9875-c9f0-43f2-8041-180f71596955";
        /*
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                console.log(this.responseText);
            }
        };
        xhttp.open("GET", "http://127.0.0.1:8080/serie/findRate/9", true);
        xhttp.setRequestHeader("AUTHORIZATION", "7e24321b-74bd-4e5b-8d61-fafbe1212208");
        xhttp.send();
        */

        $.ajax({
            type: "GET",
            crossDomain: true,
            headers: {
                'AUTHORIZATION': '7e24321b-74bd-4e5b-8d61-fafbe1212208',
                'Access-Control-Allow-Credentials': true,
                'Access-Control-Allow-Origin': true
            },
            beforeSend: function (request) {
                request.setRequestHeader("AUTHORIZATION", "7e24321b-74bd-4e5b-8d61-fafbe1212208");
            },
            url: "http://127.0.0.1:8080/serie/findRate/9",
            //data: JSON.stringify({ usuario: "SamuelAkeTello", password: "12345678" }),
            processData: false,
            //contentType: "application/json",
            success: function (msg) {
                console.log(msg);
            },
            error: function (xhr, ajaxOptions, throwError) {
                console.log(xhr);
            },
        });

    });
});
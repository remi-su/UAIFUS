$(document).ready(function () {
    $("#askVideo").on("click", function () {
        alert("uwu");
        var token = "003f9875-c9f0-43f2-8041-180f71596955";
        $.ajax({
            type: "GET",
            beforeSend: function (request) {
                request.setRequestHeader("AUTHORIZATION", "003f9875-c9f0-43f2-8041-180f71596955");
            },
            url: "http://localhost:8080/serie/findRate/9",
            //data: JSON.stringify({ usuario: "SamuelAkeTello", password: "12345678" }),
            processData: false,
            contentType: "application/json",
            success: function (msg) {
                console.log(msg);
            }
        });
    });
});
$(document).ready(function () {

//show the customer Error Message
var custommessage = GetURLParameter('server');
if(custommessage!=null){
    toastr["error"](custommessage.split("+").join(" "));
}


function GetURLParameter(sParam) {
    var sPageURL = window.location.search.substring(1);
    var sURLVariables = sPageURL.split('&');
    for (var i = 0; i < sURLVariables.length; i++) {
        var sParameterName = sURLVariables[i].split('=');
        if (sParameterName[0] == sParam) {
            return sParameterName[1];
        }
    }
}

});

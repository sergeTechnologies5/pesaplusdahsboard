$(document).ready(function () {


    toastr.options = {
        "closeButton": false,
        "debug": false,
        "newestOnTop": false,
        "progressBar": false,
        "positionClass": "toast-bottom-right",
        "preventDuplicates": false,
        "onclick": null,
        "showDuration": "1000",
        "hideDuration": "10000",
        "timeOut": "10000",
        "extendedTimeOut": "10000",
        "showEasing": "swing",
        "hideEasing": "linear",
        "showMethod": "fadeIn",
        "hideMethod": "fadeOut"
    };

    $(".submitIcon").hide();
    $('#RegisterUserFormSUbmit').click(function (e) {
        $(".submitIcon").show();

        var dataForm = {
            firstName: $("#firstName").val(),
            lastName: $("#lastName").val(),
            phoneNumber: $("#phoneNumber").val(),
            email: $("#email").val(),
            nationalId: $("#nationalId").val(),
            passportNo: $("#passportNo").val(),
            isActive: $("#isActive").val(),
            isStaff: $("#isStaff").val(),
            isSuperuser: $("#isSuperuser").val(),
            roleName: $("#roleName").val()
        };

        console.log(JSON.stringify(dataForm));
        // url: 'https://197.248.124.61:9095/api/v1/member',
        //   url: '/register_customer_api',
        //    alert("Trying to send data");
        //    alert(userToken);

        $.ajax({
            url: '/createUser',
            type: 'post',
            contentType: 'application/json',
            data: JSON.stringify(dataForm),
            success: function (data, textStatus, jQxhr) {
                toastr["success"](data);
                $(".submitIcon").hide();
                //clear the form
                $( '#RegisterUserForm' ).each(function(){
                    this.reset();
                });
            },
            error: function (jqXhr, textStatus, errorThrown) {
                console.log(errorThrown);
                toastr["error"](errorThrown);
                $(".submitIcon").hide();
            }
        });
        e.preventDefault;
    });


});

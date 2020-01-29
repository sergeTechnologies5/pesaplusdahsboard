$(document).ready(function () {

    var table = $('#customers').DataTable({
        searching: true,
        paging: true,
        select: true
    });
    table.column(2).visible(false);
    //implement search within column
    // $("#customers tfoot  th").each(function () {
    //     var title=$("#customers thead  th").eq($(this).index()).text();
    //     $(this).html('<input type="text" placeholder="search '+title+ '" />');
    // });

    $("#customers thead  th").each(function () {
        var title = $("#customers tfoot  th").eq($(this).index()).text();
        if ($(this).index() < 2) {
            $(this).html('<input type="text" placeholder="search ' + title + '" />');
        }
    });

    table.columns().every(function () {
        var datatableColumn = this;
        var searchTextBox = $(this.header()).find('input');
        searchTextBox.on('keyup change', function () {
            datatableColumn.search(this.value).draw();
        });
        searchTextBox.on('click', function (e) {
            e.stopPropagation();
        })
    });


    //  $('td:nth-child(3),th:nth-child(3)').hide();
    //open Modal for editing
    table.on('click', '.editing', function () {
        $tr = $(this).closest('tr');
        var data = table.row($tr).data();
        $("#names").val(data[0]);
        $("#phoneNumber").val(data[1]);
        $("#customerId").val(data[2]);
        $("#editModal").modal();
        // alert('You press on Row: ' + data[0] + ' ' + data[1] + ' ' + data[2] + '\'s row.');
    });

    //open modal for reset pin
    table.on('click', '.resetPin', function () {
        $tr = $(this).closest('tr');
        var data = table.row($tr).data();
        $("#resetPinNames").html(data[0]);
        $("#resetPinCustomerID").html(data[2]);
        $("#resetPinPhoneNumber").html(data[1]);
        $("#resetPin").modal();
        // alert('You press on Row: ' + data[0] + ' ' + data[1] + ' ' + data[2] + '\'s row.');
    });

    //open modal for DeActivate
    table.on('click', '.deactivate', function () {
        $tr = $(this).closest('tr');
        var data = table.row($tr).data();
        $("#deactivateCustomerNames").html(data[0]);
        $("#deactivateCustomerID").html(data[2]);
        $("#deactivateCustomerPhoneNumber").html(data[1]);
        $("#deactivateCustomer").modal();
        // alert('You press on Row: ' + data[0] + ' ' + data[1] + ' ' + data[2] + '\'s row.');
    });

    //reset pin form
    // $("#resetPinPhoneNumber").html();
    $('#resetPinFormSubmit').click(function (e) {
        var dataForm = {
            pin: "1234",
            phoneNumber: $("#resetPinPhoneNumber").html(),
            id: $("#resetPinCustomerID").html()
        };
        //  console.log(JSON.stringify(dataForm));
        //   url: 'https://197.248.124.61:9095/api/v1/member/reset-pin',
        $('#resetPin').modal('hide');
        $.ajax({
            url: '/update_customer_pin',
            type: 'post',
            contentType: 'application/json',
            data: JSON.stringify(dataForm),
            success: function (data, textStatus, jQxhr) {
                toastr["success"](data);
            },
            error: function (jqXhr, textStatus, errorThrown) {
                toastr["error"](errorThrown);
            }
        });
        e.preventDefault;
    });


    //deactivate Customer
    $('#deactivateCustomerFormSubmit').click(function (e) {
        var dataForm = {
            phoneNumber: $("#deactivateCustomerPhoneNumber").html(),
            id: $("#deactivateCustomerID").html()
        };

        //   url: 'https://197.248.124.61:9095/api/v1/member/reset-pin',
        $.ajax({
            url: '/update_customer_pin',
            type: 'post',
            contentType: 'application/json',
            data: JSON.stringify(dataForm),
            success: function (data, textStatus, jQxhr) {
                $('#deactivateCustomer').modal('hide');
                toastr["success"](data);
               // setInterval('location.reload()', 3000);
            },
            error: function (jqXhr, textStatus, errorThrown) {
                $('#deactivateCustomer').modal('hide');
                toastr["error"](errorThrown);
            }
        });
        e.preventDefault;
    });


//edit customer deatils
    $('#editCustomerFormSubmit').click(function (e) {
        var dataForm = {
            pin: $("#pin").val(),
            phoneNumber: $("#phoneNumber").val(),
            id: $("#customerId").val()
        };

        //   url: 'https://197.248.124.61:9095/api/v1/member/reset-pin',
        $.ajax({
            url: '/update_customer_pin',
            type: 'post',
            contentType: 'application/json',
            data: JSON.stringify(dataForm),
            success: function (data, textStatus, jQxhr) {
                $('#editModal').modal('hide');
                toastr["success"](data);
                setInterval('location.reload()', 3000);
                // $("#snackbar").html(data).addClass("show");
                // setTimeout(function () {
                //     $("#snackbar").removeClass("show");
                // }, 5000);
            },
            error: function (jqXhr, textStatus, errorThrown) {
                console.log(errorThrown);
                $('#editModal').modal('hide');
                toastr["error"](errorThrown);
            }
        });
        e.preventDefault;
    });


});

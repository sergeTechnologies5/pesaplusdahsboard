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
    //open Modal for editi


    //open modal for Activate
    table.on('click', '.activate', function () {

        $tr = $(this).closest('tr');
        var data = table.row($tr).data();
        $("#activateCustomerNames").html(data[0]);
        $("#activateCustomerID").html(data[2]);
        $("#activateCustomerPhoneNumber").html(data[1]);
        $("#activateCustomer").modal();
        // alert('You press on Row: ' + data[0] + ' ' + data[1] + ' ' + data[2] + '\'s row.');
    });


    //activate Customer
    $('#activateCustomerFormSubmit').click(function (e) {
        var dataForm = {
            customerID: $("#activateCustomerID").html()
        };
        //   url: 'https://197.248.124.61:9095/api/v1/member/reset-pin',
        $('#activateCustomer').modal('hide');

        $.ajax({
            url: '/activate_customer',
            type: 'post',
            contentType: 'application/json',
            data: JSON.stringify(dataForm),
            success: function (data, textStatus, jQxhr) {
                toastr["success"](data);
                setInterval('location.reload()', 3000);
                // $("#snackbar").html(data).addClass("show");
                // setTimeout(function () {
                //     $("#snackbar").removeClass("show");
                // }, 3000);
            },
            error: function (jqXhr, textStatus, errorThrown) {
                console.log(errorThrown);
                toastr["error"](errorThrown);
                // $("#snackbar").html(errorThrown).addClass("show");
                // setTimeout(function () {
                //     $("#snackbar").removeClass("show");
                // }, 3000);
            }
        });
        e.preventDefault;
    });


});

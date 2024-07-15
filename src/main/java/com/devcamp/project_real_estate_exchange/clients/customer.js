"use strict";
/*** REGION 1 - Global variables - Vùng khai báo biến, hằng số, tham số TOÀN CỤC */

const gBASE_URL = "http://127.0.0.1:8000/customers/";

let gId;

const gColumns = [
    'id',
    'contactName',
    'contactTitle',
    'address',
    'mobile',
    'email',
    'createBy',
    'updateBy',
    'createDate',
    'updateDate',
    'action'
];



const gDataTable = $("table").DataTable({
    columns: [
        { data: gColumns[0], title: "id" },
        { data: gColumns[1], title: "contactName" },
        { data: gColumns[2], title: "contactTitle" },
        { data: gColumns[3], title: "address" },
        { data: gColumns[4], title: "mobile" },
        { data: gColumns[5], title: "email" },
        { data: gColumns[6], title: "createBy" },
        { data: gColumns[7], title: "updateBy" },
        { data: gColumns[8], title: "createDate" },
        { data: gColumns[9], title: "updateDate" },
        { data: gColumns[10], title: "action" },

    ],
    columnDefs: [
        {
            targets: 10,
            defaultContent: `<button class='btn-edit btn-link' data-toggle="tooltip" data-placement="bottom"
            title="Item Edit"><i  class="fa-solid fa-cube fa-lg text-secondary"></i></button>
                    <button class='btn-delete btn-link' data-toggle="tooltip" data-placement="bottom"
                    title="Item Delete"><i  class="fa-solid fa-user-minus fa-lg text-secondary"></i></button>`
        }

    ]

})
/*** REGION 2 - Vùng gán / thực thi hàm xử lý sự kiện cho các elements */
// Hàm xử lý sự kiện tải trang
function onPageLoading() {

    //    console.log("loading...");

    $.ajax({
        url: gBASE_URL,
        type: 'get',
        success: function (success) {
            // console.log(paramSuccess);
            // Funtion load data to table
            gDataTable.clear();
            gDataTable.rows.add(success);
            gDataTable.draw();

        },
        error: function (err) {
            0
            alert("err");
        }
    })


}

$(document).on("click", "#btn-add", function () {
    onBtnAddClick();
})


$(document).on("click", ".btn-edit", function (e) {
    onBtnEditClick(this);
})


$(document).on("click", ".btn-delete", function (e) {
    onBtnDeleteClick(this);
})








/*** REGION 3 - Event handlers - Vùng khai báo các hàm xử lý sự kiện */
function onBtnAddClick() {
    // console.log("add...");
    $("#modal-create-edit").modal("show");
    $(document).on("click", "#btn-create", function () {

        // console.log("create...");
        // Collect data

        // create object
        let vVariable = new Object();
        // retrieve data and attach to value
        vVariable.contactName = $("#input-create-edit-name").val();
        vVariable.address = $("#input-create-edit-address").val();
        vVariable.email = $("#input-create-edit-email").val();
        vVariable.mobile = $("#input-create-edit-mobile").val();
        vVariable.createDate = $("#input-create-edit-createDate").val();
        vVariable.updateDate = $("#input-create-edit-updateDate").val();
        vVariable.note = $("#textarea-create-edit-description").val();

        // console.log(vVariable);
        // Call api create customer
        $.ajax({
            url: gBASE_URL,
            method: "POST",
            contentType: "application/json",
            data: JSON.stringify(vVariable),
            success: function (success) {
                alert("Create course successfully...");
                // console.log(success);
                onPageLoading();

                $("#input-create-edit-name").val("");
                $("#input-create-edit-address").val("");
                $("#input-create-edit-email").val("");
                $("#input-create-edit-mobile").val("");
                $("#input-create-edit-createDate").val("");
                $("#input-create-edit-updateDate").val("");
                $("#textarea-create-edit-description").val("");

                $("#modal-create-edit").modal("hide");
            },
            error: function (err) {
                alert("err");
            }
        })
    })
}


function onBtnEditClick(params) {
    // console.log("edit...");
    gId = getIdFromButton(params)
    // console.log(gId);


    $.ajax({
        url: gBASE_URL + gId,
        method: "get",
        success: function (success) {
            // console.log(params.id);
            // modal on
            $("#modal-create-edit").modal("show");
            // ham load data to modal
            // showDeparmentDataToModal(params);
            $("#input-create-edit-name").val(success.contactName);
            $("#input-create-edit-address").val(success.address);
            $("#input-create-edit-email").val(success.email);
            $("#input-create-edit-mobile").val(success.mobile);
            $("#input-create-edit-createDate").val(success.createDate);
            $("#input-create-edit-updateDate").val(success.updateDate);
            $("#textarea-create-edit-description").val(success.note);
        },
        error: function (err) {
            alert("err");
        }
    })

    $(document).on("click", "#btn-update", function () {


        // console.log("update...");
        // Collect data


        // create object
        let vVariable = new Object();
        // retrieve data and attach to value
        vVariable.contactName = $("#input-create-edit-name").val();
        vVariable.address = $("#input-create-edit-address").val();
        vVariable.email = $("#input-create-edit-email").val();
        vVariable.mobile = $("#input-create-edit-mobile").val();
        vVariable.createDate = $("#input-create-edit-createDate").val();
        vVariable.updateDate = $("#input-create-edit-updateDate").val();
        vVariable.note = $("#textarea-create-edit-description").val();


        // console.log(vVariable);
        // call api
        callApiUpdateById(gId, vVariable);
        function callApiUpdateById(paramId, paramObj) {
            $.ajax({
                url: gBASE_URL + gId,
                method: "put",
                contentType: "application/json",
                data: JSON.stringify(vVariable),
                success: function (params) {
                    alert("Customer update succesfully...")
                    // console.log(params);
                    onPageLoading();
                    $("#modal-create-edit").modal("hide");

                },
                error: function (params) {
                    alert("err");
                }
            })
        }


    })



}



function onBtnDeleteClick(params) {
    // console.log("delete...");
    gId = getIdFromButton(params);
    // console.log(gId);



    $.ajax({
        url: gBASE_URL + gId,
        method: "get",
        success: function (success) {
            // console.log(success.id);


        },
        error: function (err) {
            alert("err");
        }
    })

    $(".modal-delete").modal("show");
    $(document).on("click", "#btn-confirm", function () {


        // console.log("confirm...");


        $.ajax({
            url: gBASE_URL + gId,
            method: "delete",
            success: function (success) {
                alert("Delete successfully...");

                onPageLoading();
                $(".modal-delete").modal("hide");

            },
            error: function (err) {
                alert("err");
            }
        })


    })
}




/*** REGION 4 - Common funtions - Vùng khai báo hàm dùng chung trong toàn bộ chương trình*/




function getIdFromButton(params) {
    // console.log("dfkjd");
    // tim den cai row tren data table
    let vTableRow = $(params).parents("tr");
    // console.log(vTableRow);
    // lay gia tri cua row va ghi vao bien
    let vDataTableRow = gDataTable.row(vTableRow).data();
    // console.log(vDataTableRow.id);

    return vDataTableRow.id;

}




















// Funtion validate
function checkData(paramPetObj) {

    $(".form-control").removeClass("is-invalid");
    let isValid = true;
    //Name: Text
    if (paramPetObj.name === "") {
        $("#input-create-edit-name").addClass("is-invalid");
        $("#input-create-edit-name ~.invalid-feedback").text("Please enter name");
        isValid = false;
    }
    //Type: Text
    if (paramPetObj.type === "") {
        $("#input-create-edit-type").addClass("is-invalid");
        $("#input-create-edit-type ~.invalid-feedback").text("Please select type");
        isValid = false;
    }

    // Url Image: text 
    if (paramPetObj.imageUrl === "") {
        $("#input-create-edit-ImageUrl").addClass("is-invalid");
        $("#input-create-edit-ImageUrl ~.invalid-feedback").text("Please enter link image");
        isValid = false;
    } else if (/\.(jpg|png|gif|jpeg|svg)/gi.test(paramPetObj.imageUrl) === false) {
        $('#input-create-edit-ImageUrl').addClass("is-invalid");
        $('#input-create-edit-ImageUrl ~ .invalid-feedback').text("Pet image must be .jpg, .png, .gif, .jpeg, .svg");
        isValid = false;
    }

    //Price: whole number and > 0
    if (paramPetObj.price === null) {
        $("#input-create-edit-price").addClass("is-invalid");
        $("#input-create-edit-price ~.invalid-feedback").text("Please enter price");
        isValid = false;
    } else if (paramPetObj.price <= 0) {
        $("#input-create-edit-price").addClass("is-invalid");
        $("#input-create-edit-price ~.invalid-feedback").text("Price must be over 0");
        isValid = false;
    }

    //Promotion whole Price : number, >= 0 and <= price
    if (paramPetObj.promotionPrice === null) {
        $("#input-create-edit-promotion-price").addClass("is-invalid");
        $("#input-create-edit-promotion-price ~.invalid-feedback").text("Please enter Promotion price");
        isValid = false;
    }
    else if (paramPetObj.promotionPrice < 0 || paramPetObj.promotionPrice > paramPetObj.price) {
        $("#input-create-edit-promotion-price").addClass("is-invalid");
        $("#input-create-edit-promotion-price ~.invalid-feedback").text("Promotion price must be over or equal 0 and smaller than price");
        isValid = false;
    }

    //Discount : whole number, >= 0 and <= 100
    if (paramPetObj.discount < 0 || paramPetObj.discount > 100) {
        $("#input-create-edit-discount").addClass("is-invalid");
        $("#input-create-edit-discount ~.invalid-feedback").text("Discount must be over or equal 0 and smaller than 100");
        isValid = false;
    }

    // Description: text
    if (paramPetObj.description === "") {
        $("#textarea-create-edit-description").addClass("is-invalid");
        $("#textarea-create-edit-description ~.invalid-feedback").text("Please enter pet description");
        isValid = false;
    } else if (paramPetObj.description.length < 20) {
        $("#textarea-create-edit-description").addClass("is-invalid");
        $("#textarea-create-edit-description ~ .invalid-feedback").text("Description must be over 20 letter");
        isValid = false;
    }

    return isValid;
}









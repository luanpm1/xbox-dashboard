"use strict";
/*** REGION 1 - Global variables - Vùng khai báo biến, hằng số, tham số TOÀN CỤC */

const gBASE_URL = "http://127.0.0.1:8000/realestates/";

let gId;

const gColumns = [
    'id',
    'title',
    'type',
    "request",
    "address",
    "price",
    "dateCreate",
    "acreage",
    "direction",
    "totalFloors",
    "numberFloors",
    "bathroom",
    "apartmentCode",
    "wallArea",
    "bedroom",
    "landscapeView",
    "apartmentLocal",
    "apartmentType",
    "furnitureType",
    "priceRent",
    "legalDoc",
    "description",
    "_width",
    "_long",
    "streetHouse",
    "viewNum",
    "createBy",
    "updateBy",
    "factor",
    "structure",
    "photo",
    "_lat",
    "_lng",
    'action'
];



const gDataTable = $("table").DataTable({
    columns: [
        { data: gColumns[0], title: "id" },
        { data: gColumns[1], title: "title" },
        { data: gColumns[2], title: "type" },
        { data: gColumns[3], title: "request" },
        { data: gColumns[4], title: "address" },
        { data: gColumns[5], title: "price" },
        { data: gColumns[6], title: "dateCreate" },
        { data: gColumns[7], title: "acreage" },
        { data: gColumns[8], title: "direction" },
        { data: gColumns[9], title: "totalFloors" },
        { data: gColumns[10], title: "numberFloors" },
        { data: gColumns[11], title: "bathroom" },
        { data: gColumns[12], title: "apartmentCode" },
        { data: gColumns[13], title: "wallArea" },
        { data: gColumns[14], title: "bedroom" },
        { data: gColumns[15], title: "landscapeView" },
        { data: gColumns[16], title: "apartmentLocal" },
        { data: gColumns[17], title: "apartmentType" },
        { data: gColumns[18], title: "priceRent" },
        { data: gColumns[19], title: "legalDoc" },
        { data: gColumns[20], title: "description" },
        { data: gColumns[21], title: "_width" },
        { data: gColumns[22], title: "_long" },
        { data: gColumns[23], title: "streetHouse" },
        { data: gColumns[24], title: "viewNum" },
        { data: gColumns[25], title: "createBy" },
        { data: gColumns[26], title: "updateBy" },
        { data: gColumns[27], title: "factor" },
        { data: gColumns[28], title: "structure" },
        { data: gColumns[29], title: "photo" },
        { data: gColumns[30], title: "_lat" },
        { data: gColumns[31], title: "_lng" },
        { data: gColumns[32], title: "action" }

    ],
    columnDefs: [
        {
            targets: 32,
            defaultContent: `<button class='btn-edit btn-link' data-toggle="tooltip" data-placement="bottom"
            title="Item Edit"><i  class="fa-solid fa-cube fa-lg text-secondary"></i></button>
                    <button class='btn-delete btn-link' data-toggle="tooltip" data-placement="bottom"
                    title="Item Delete"><i  class="fa-solid fa-user-minus fa-lg text-secondary"></i></button>`
        },
        {
            targets: 29,
            render: function (data) {
                // console.log(data);
                return `<img style="height: 100px;width: 100px;" src="${data}" alt="image">`
            }
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
            // Funtion show data to table
            gDataTable.clear();
            gDataTable.rows.add(success);
            gDataTable.draw();

        },
        error: function (err) {
            alert("err");
        }
    })


}











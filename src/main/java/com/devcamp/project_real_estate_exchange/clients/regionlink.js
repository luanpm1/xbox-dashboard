"use strict";
/*** REGION 1 - Global variables - Vùng khai báo biến, hằng số, tham số TOÀN CỤC */

const gBASE_URL = "http://127.0.0.1:8000/regionLinks/";

let gId;

const gColumns = [
    'id',
    'name',
    'description',
    "photo",
    "address",
    "_lat",
    "_lng",
    'action'
];



const gDataTable = $("table").DataTable({
    columns: [
        { data: gColumns[0], title: "id" },
        { data: gColumns[1], title: "name" },
        { data: gColumns[2], title: "description" },
        { data: gColumns[3], title: "photo" },
        { data: gColumns[4], title: "address" },
        { data: gColumns[5], title: "_lat" },
        { data: gColumns[6], title: "_lng" },
        { data: gColumns[7], title: "action"}

    ],
    columnDefs: [
        {
            targets: 7,
            defaultContent: `<button class='btn-edit btn-link' data-toggle="tooltip" data-placement="bottom"
            title="Item Edit"><i  class="fa-solid fa-cube fa-lg text-secondary"></i></button>
                    <button class='btn-delete btn-link' data-toggle="tooltip" data-placement="bottom"
                    title="Item Delete"><i  class="fa-solid fa-user-minus fa-lg text-secondary"></i></button>`
        },
        {
            targets: 3,
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











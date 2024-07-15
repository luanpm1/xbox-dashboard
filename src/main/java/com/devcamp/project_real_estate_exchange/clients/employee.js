"use strict";
/*** REGION 1 - Global variables - Vùng khai báo biến, hằng số, tham số TOÀN CỤC */

const gBASE_URL = "http://127.0.0.1:8000/employees/";

let gId;

const gColumns = [
    'id',
    'firstName',
    'lastName',
    'title',
    'photo',
    'birthday',
    'address',
    'city',
    'region',
    'postalCode',
    'country',
    'homePhone',
    'userName',
    'password',
    'email',
    'action'
];



const gDataTable = $("table").DataTable({
    columns: [
        { data: gColumns[0], title: "id" },
        { data: gColumns[1], title: "firstName" },
        { data: gColumns[2], title: "lastName" },
        { data: gColumns[3], title: "title" },
        { data: gColumns[4], title: "photo" },
        { data: gColumns[5], title: "birthday" },
        { data: gColumns[6], title: "address" },
        { data: gColumns[7], title: "city" },
        { data: gColumns[8], title: "region" },
        { data: gColumns[9], title: "postalCode" },
        { data: gColumns[10], title: "country" },
        { data: gColumns[11], title: "homePhone" },
        { data: gColumns[12], title: "userName" },
        { data: gColumns[13], title: "password" },
        { data: gColumns[14], title: "email" },
        { data: gColumns[15], title: "action" },

    ],
    columnDefs: [
        {
            targets: 15,
            defaultContent: `<button class='btn-edit btn-link' data-toggle="tooltip" data-placement="bottom"
            title="Item Edit"><i  class="fa-solid fa-cube fa-lg text-secondary"></i></button>
                    <button class='btn-delete btn-link' data-toggle="tooltip" data-placement="bottom"
                    title="Item Delete"><i  class="fa-solid fa-user-minus fa-lg text-secondary"></i></button>`
        },
        {
            targets: 4,
            render: function (data) {
                // console.log(data);
                return `<img style="height: 100px;width: 100px;" src="${data}" alt="">`
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
            // Funtion load data to table
            gDataTable.clear();
            gDataTable.rows.add(success);
            gDataTable.draw();

        },
        error: function (err) {
            alert("err");
        }
    })


}









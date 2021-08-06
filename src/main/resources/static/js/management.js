//const CONTEXT="http://localhost:8082";
let productid;
let id;
let newId;
let product;

$(document).ready(function(){

    $(document).on("click","#editButton", function (e) {
        e.preventDefault();


        productid=$(this).attr("pid");
        id=$("#productid"+productid);
        newId=parseInt(id.val());

        let url=`http://localhost:8082/manageProduct/find/${newId}`;

        const request=new XMLHttpRequest();

        jQuery.noConflict();
        jQuery("#editProductModal").modal({show:true});



        request.open('GET',url);
        request.send();

        request.onload = () => {


            product=JSON.parse(request.response);

            $("#pId").val(product.productId);
            $("#pName").val(product.product_name);
            jQuery("#pDesc").val(product.product_desc);
            $("#pPriceInput").val(product.product_price);
            $("#pImg").html(product.product_img);
            $("#pCat").html(product.product_category);



        }
    });



    $("#updateBtn").click( function (e) {
        e.preventDefault();

        let url=`http://localhost:8082/manageProduct/update`;

        let pId=product.productId;
        let pName=product.product_name;
        let pDesc=product.product_desc;
        let pPrice=product.product_price;
        let pCat=product.product_category;
        let pImg=product.product_img;
        alert(pId);
        let data = {"productId":pId,
                    "product_name":pName,
                    "product_desc":pDesc,
                    "product_price":pPrice,
                    "product_category":pCat,
                    "product_Img":pImg
        }

        $.ajax({
            type: 'PUT',
            url: url,
            beforeSend: function (xhr) {
                xhr.setRequestHeader(myheader, mycsrf)
            },
            contentType: 'application/json',
            data: JSON.stringify(data), // access in body
        }).done(function () {
            console.log('SUCCESS');
        }).fail(function (msg) {
            console.log('FAIL');
        }).always(function (msg) {
            console.log('ALWAYS');
        });

    });

      $("#deleteConfirmBtn").click( function (e) {
              e.preventDefault();

          let url=`http://localhost:8082/manageProduct/delete/${newId}`;
          $.ajax({
              type: "DELETE",
              url: url,
              beforeSend: function (xhr) {
                  xhr.setRequestHeader(myheader, mycsrf)
              }
          }).done();
      });

      $(document).on("click", "#deleteBtn", function (evt){
          evt.preventDefault();

          productid=$(this).attr("pid");
          id=$("#productid"+productid);
          newId=parseInt(id.val());

      });
});


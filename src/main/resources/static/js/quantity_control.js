

$(document).ready(function(){

    $(".minusButton").on("click", function (evt) {
        evt.preventDefault();

        let productId = $(this).attr("pid");
        let cartId = $("#cart_id" + productId);
        let newcartId=parseInt(cartId.val());
        let quantity = $("#quantity" + productId);
        let newQty = parseInt(quantity.val()) - 1;
        if (newQty > 0) quantity.val(newQty);


        let url = `http://localhost:8082/shopping/update/${newQty}/${newcartId}`;

        $.ajax({
            type:"PUT",
            url:url,
            beforeSend: function (xhr){
                xhr.setRequestHeader(myheader,mycsrf)
            }
        }).done();
    });

    $(".plusButton").on("click", function (evt) {
        evt.preventDefault();

        let productId = $(this).attr("pid");
        let cartId = $("#cart_id" + productId);
        let newcartId=parseInt(cartId.val());
        console.log("fghgfo: "+ cartId);
        console.log("fghgf: "+ newcartId);
        let quantity = $("#quantity" + productId);
        let newQty = parseInt(quantity.val()) + 1;

        alert("fghgf2: "+ newQty);
        if (newQty > 0) {
            quantity.val(newQty);


            let url = `http://localhost:8082/shopping/update/${newQty}/${newcartId}`;

            $.ajax({
                type:"PUT",
                url:url,
                beforeSend: function (xhr){
                    xhr.setRequestHeader(myheader,mycsrf)
                }
            }).done();

        }
    });
});
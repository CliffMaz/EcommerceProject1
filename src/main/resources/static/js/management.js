//const CONTEXT="http://localhost:8082";
let productid;
let id;
let newId;
$(document).ready(function(){



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

      $(document).on("hover", "#deleteBtn", function (evt){
          evt.preventDefault();

          productid=$(this).attr("pid");
          id=$("#productid"+productid);
          newId=parseInt(id.val());

      });
});


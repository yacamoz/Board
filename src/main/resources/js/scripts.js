$(".replyWrite[type=submit]").click(addReply);

function addReply(e) {
    e.preventDefault();
    console.log("click!");

    var queryString = $(".replyWrite").serialize();
    console.log("qeury: "+ queryString);

    var url = $(".replyWrite").attr("action");

    $.ajax({
        type:"post",
        url:url,
        data:queryString,
        dataType:'json',
        error:onError,
        success:onSuccess});
}
function onError(){

}
function  onSuccess(){

}
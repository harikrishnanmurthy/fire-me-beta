$(document).ready(function() {
    if ($('#dwnldGST').length){
    	$('#gstfilebutton').css("background-color","#C0C0C0");
    	$('#gstfilebutton').attr('disabled','disabled');
    	$('#gstfiletype').attr('disabled','disabled');
    	$('#gstfiletype').css("background-color");
    }
});
$('#gcrtemplate').click(function() {
	  downloadTemplate();
    });
$('#gstcalcfile').click(function() {
	  alert("gst calc file");
	  downloadGstCalcFile();
  });
$('#gsterrorfile').click(function() {
	  alert("gst error file");
	  downloadGstErrorFile();
});
function downloadTemplate() {
	window.location.href='/gst-gcr-webportal/downloadTemplate';
}
function downloadGstCalcFile() {
	window.location.href='/gst-gcr-webportal/downloadGstCalcFile';
}
function downloadGstErrorFile() {
	window.location.href='/gst-gcr-webportal/downloadGstErrorFile';
}

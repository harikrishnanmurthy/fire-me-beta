/* =========================================================
 * bootstrap-timepicker.js
 * https://github.com/Bloafer/bootstrap-timepicker
 * =========================================================
 * Copyright 2012 Bloafer ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ========================================================= */

(function( $ ){

  var methods = {
    init : function( options ) { 
      if($(".timepicker-popup").length==0){
        var hours           = 23;
        var minutes         = 59;
        var seconds         = 59;
        var seperator       = ":";
        var popup           = $("<div>");
        var tableDiv        = $("<div style='float: left;'>");
        var table           = $("<table>");
        var tableHour       = $("<td>");
        var tableMinute     = $("<td>");
        var tableSecond     = $("<td>");
        var tableSeperator  = $("<td>");
        var tableSeperator2  = $("<td>");
        var tbody			= $("<tbody>");
        var tbodyTr			= $("<tr>");
        var hour            = $("<select>");
        var minute          = $("<select>");
        var second          = $("<select>");
        var setButton       = $("<div style='float: left; padding: 25px 5px 0px 15px;'><button id='timepicker-select' class='btn btn-mini btn-info db-btn'>Set</button></div>");
        var clearButton     = $("<div style='float: left; padding: 25px 10px 0px 0px;'><button id='timepicker-clear' class='btn btn-mini db-btn'>Clear</button></div>");
        for(var h=0; h<=hours; h++){
          h = (h < 10) ? ("0" + h) : h;
          var rowHour = $("<option>");
          rowHour
            .attr("value", h)
            .text(h)
          ;
          hour.append(rowHour);
        }
        for(var m=0; m<=minutes; m++){
          m = (m < 10) ? ("0" + m) : m;
          var rowMinute = $("<option>");
          rowMinute
            .attr("value", m)
            .text(m)
          ;
          minute.append(rowMinute);
        }
        for(var s=0; s<=seconds; s++){
            s = (s < 10) ? ("0" + s) : s;
            var rowMinute = $("<option>");
            rowMinute
              .attr("value", s)
              .text(s)
            ;
            second.append(rowMinute);
          }
        hour.addClass("timepicker-popup-hour");
        minute.addClass("timepicker-popup-minute");
        second.addClass("timepicker-popup-second");
        tableHour.append(hour);
        tableSeperator.text(seperator);
        tableSeperator2.text(seperator);
        tableMinute.append(minute);
        tableSecond.append(second);
        tbodyTr.append(tableHour)
          .append(tableSeperator)
          .append(tableMinute)
          .append(tableSeperator2)
          .append(tableSecond);
        tbody.append(tbodyTr);
        table.append("<thead><tr><th>Hour</th><th> </th><th>Min</th><th> </th><th>Sec</th></thead>")
          .append(tbody);
        popup.addClass("timepicker-popup")
          .addClass("dropdown-menu")
          .css("display", "block")
          .append(tableDiv.append(table))
          .append(setButton)
          .append(clearButton)
          .hide();
        $("body").append(popup);
      }
      return this.each(function(){
        $(this).bind("focus", function(){
          var thisOffset = $(this).offset();
          $(".timepicker-popup-hour, .timepicker-popup-minute, .timepicker-popup-second").val("00");
          if($(this).val()!=""){
            var inputTime = $(this).val();
            inputTime = inputTime.replace(/[hms]/g, ":");
            var splitTime = inputTime.split(":");
            if(splitTime.length==4){
              $(".timepicker-popup-hour").val(splitTime[0]);
              $(".timepicker-popup-minute").val(splitTime[1]);
              $(".timepicker-popup-second").val(splitTime[2]);
            }
          }
          var timePickerPopup = $(".timepicker-popup");
          timePickerPopup
            .css("position", "absolute")
            .css("left", thisOffset.left + "px")
            .css("top", thisOffset.top + $(this).outerHeight(true) + "px")
            .data("caller", this)
            .show()
          ;
        });
        $("#timepicker-select").click(function() {
        	var caller = $(".timepicker-popup").data("caller");
            $(caller).val($(".timepicker-popup-hour").val() + "h" + $(".timepicker-popup-minute").val() + "m" + $(".timepicker-popup-second").val() + "s");
            $(".timepicker-popup").hide();
        });
        $("#timepicker-clear").click(function() {
        	var caller = $(".timepicker-popup").data("caller");
        	$(caller).val('');
            $(".timepicker-popup").hide();
        });
        $(document).on('mousedown.timepicker', function (e) {
            // Clicked outside the timepicker, hide it
            if ($(e.target).closest('.timepicker-popup').length === 0) {
            	$(".timepicker-popup").hide();
            }
        });
      });
    }
  };
  $.fn.timepicker = function( method ) {
    if ( methods[method] ) {
      return methods[ method ].apply( this, Array.prototype.slice.call( arguments, 1 ));
    } else if ( typeof method === 'object' || ! method ) {
      return methods.init.apply( this, arguments );
    } else {
      $.error( 'Method ' +  method + ' does not exist on jQuery.timepicker' );
    }
  };

})( jQuery );
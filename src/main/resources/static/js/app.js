$(document).ready(function(){
});

var TransportMean = new function(){
    var my = [];

    my.VehicleChanged = function(){
        var vehicle = document.getElementById('vehicle');
        var idVehicle = vehicle.value;

        var elementsToDisable = ['container', 'material', 'amount'];

        $.get("/vehicle/getVehicleType?id=" + idVehicle, function( vehicleType ) {
            var shouldDisable = vehicleType == 'Personal';

            for(var i = 0; i < elementsToDisable.length; i++){
                var element = $("#" + elementsToDisable[i]);
                element.prop( "disabled", shouldDisable );
                if(shouldDisable){
                    element.val(null);
                }
            }
        });
    }

    return my;
}



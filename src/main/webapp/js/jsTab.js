;(function ($, window, undefined) {
    // Objeto PanelTab
    var PanelTab = function(elemento, opciones){
        // Objeto jQuery
        this.$elemento = $(elemento);
 
        // Llama al metodo init del objeto
        if(this.init){
            this.init(opciones);
        }
    }
 
    PanelTab.prototype = {
        // valores por defecto de nuestro objeto.
        defaults : {
            panel : '.panel'
        },
 
        init : function(opciones){
            // Guarda en la variable this.config las nuevas opciones que le pasamos al objeto
            this.config = $.extend({}, this.defaults, opciones);
 
            // Variables de nuestro objeto
            this.tabs = "." + this.$elemento.attr('class');
            var paneles = this.config.panel;
 
            // Cada vez que hacemos clic en alguno de nuestros tabs
            $(this.tabs + " a").click(function(){
                $this = $(this);
                // Escondemos el panel
                $(paneles).hide();
 
                // Obtenemos el href de nuestro tab que hicimos clic
                var panel = $this.attr('href');
 
                //Mostramos el panel con el efecto fadeIn a la velocidad de 250
                $(panel).fadeIn(250);
                return false;
            });
 
            // Lanzamos el efecto click en nuestro primer tab
            $(this.tabs + ' li:first a').click();
        },
    }
 
    //definicion de la funcion jQuery
    $.fn.tab = function(opciones){
        // Si le pasamos un objetos o no le pasamos opciones creara el objeto PanelTab
        if(typeof opciones == 'object' || !opciones){
            this.data('tab', new PanelTab(this, opciones));
        } else {
            // Si no brindara un error de parametro
            $.error("Error, parámetro incorrecto");
        }
    }
})(jQuery, window);


$(document).ready(function() {
    // Llamamos nuestro plugin
$('.panelTab').tab();

});
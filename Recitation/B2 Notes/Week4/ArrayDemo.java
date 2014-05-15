
<!-- saved from url=(0150)https://files.t-square.gatech.edu/access/content/group/gtc-26e9-b625-5afc-b059-46650cf511ae/B3%20-%20Justin%20_%20Goutam/Recitation%203/ArrayDemo.java -->
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8"><style id="clearly_highlighting_css" type="text/css">/* selection */ html.clearly_highlighting_enabled ::-moz-selection { background: rgba(246, 238, 150, 0.99); } html.clearly_highlighting_enabled ::selection { background: rgba(246, 238, 150, 0.99); } /* cursor */ html.clearly_highlighting_enabled {    /* cursor and hot-spot position -- requires a default cursor, after the URL one */    cursor: url("chrome-extension://pioclpoplcdbaefihamjohnefbikjilc/clearly/images/highlight--cursor.png") 14 16, text; } /* highlight tag */ em.clearly_highlight_element {    font-style: inherit !important; font-weight: inherit !important;    background-image: url("chrome-extension://pioclpoplcdbaefihamjohnefbikjilc/clearly/images/highlight--yellow.png");    background-repeat: repeat-x; background-position: top left; background-size: 100% 100%; } /* the delete-buttons are positioned relative to this */ em.clearly_highlight_element.clearly_highlight_first { position: relative; } /* delete buttons */ em.clearly_highlight_element a.clearly_highlight_delete_element {    display: none; cursor: pointer;    padding: 0; margin: 0; line-height: 0;    position: absolute; width: 34px; height: 34px; left: -17px; top: -17px;    background-image: url("chrome-extension://pioclpoplcdbaefihamjohnefbikjilc/clearly/images/highlight--delete-sprite.png"); background-repeat: no-repeat; background-position: 0px 0px; } em.clearly_highlight_element a.clearly_highlight_delete_element:hover { background-position: -34px 0px; } /* retina */ @media (min--moz-device-pixel-ratio: 2), (-webkit-min-device-pixel-ratio: 2), (min-device-pixel-ratio: 2) {    em.clearly_highlight_element { background-image: url("chrome-extension://pioclpoplcdbaefihamjohnefbikjilc/clearly/images/highlight--yellow@2x.png"); }    em.clearly_highlight_element a.clearly_highlight_delete_element { background-image: url("chrome-extension://pioclpoplcdbaefihamjohnefbikjilc/clearly/images/highlight--delete-sprite@2x.png"); background-size: 68px 34px; } } </style><style type="text/css"></style><style>[touch-action="none"]{ -ms-touch-action: none; touch-action: none; }[touch-action="pan-x"]{ -ms-touch-action: pan-x; touch-action: pan-x; }[touch-action="pan-y"]{ -ms-touch-action: pan-y; touch-action: pan-y; }[touch-action="scroll"],[touch-action="pan-x pan-y"],[touch-action="pan-y pan-x"]{ -ms-touch-action: pan-x pan-y; touch-action: pan-x pan-y; }</style></head><body><pre style="word-wrap: break-word; white-space: pre-wrap;">public class ArrayDemo{

    public static void main(String...args){
        //print out all numbers from 1 to 100
        System.out.println("Print square roots of numbers 1 to 100:");
        for(int i = 1; i&lt;= 100; i++){
            System.out.print(" "+i);
        }

        //print out the square roots of all numbers from 1 to 100
        System.out.println("Print square roots of numbers 1 to 100:");
        for(int i = 1; i&lt;= 100; i++){
            System.out.print(" "+Math.sqrt(i));
        }        
        
        //resize an array
        String[] array = new String[4];
        array[0] = "String at index 0";
        array[1] = "String at index 1";
        array[2] = "String at index 2";
        array[3] = "String at index 3";
        
        String newStr = "Add me!";
        //we can't just put this in array[4], because that index doesn't exist
        //let's resize the array to be one element larger
        
        String[] bigArray = new String[5];
        for(int i=0; i&lt;array.length ; i++){
            bigArray[i] = array[i];
        }
        bigArray[4] = newStr;
        
        //Let's check to see what's in the arrays
        System.out.println("array:");
        for(String element: array){
            System.out.print(" "+element);
        }
        System.put.println("bigArray:");
        for(String element: bigArray){
            System.out.println(" "+element);
        }
        
    }
}
</pre></body></html>
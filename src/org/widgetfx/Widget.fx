/*
 * WidgetFX - JavaFX Desktop Widget Platform
 * Copyright (C) 2008  Stephen Chin
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.widgetfx;
import javafx.application.Application;
import javafx.ext.swing.Component;

/**
 * @author Stephen Chin
 * @author Keith Combs
 */
public class Widget extends Application {
    public attribute name:String;
    
    public attribute resizable:Boolean = false;
    
    public attribute aspectRatio:Number = 0;
    
    public attribute config:Component;
    
    public attribute onResize:function(width:Integer, height:Integer):Void;
    
    public attribute onDock:function():Void;

    public attribute onUndock:function():Void;
}

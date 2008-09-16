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
package org.widgetfx.ui;

import java.awt.*;

/**
 * @author Stephen Chin
 */
public class NativePopupMenu extends NativeMenu {
    public attribute parent:Component on replace oldComponent=newComponent {
        oldComponent.remove(getPopupMenu());
        newComponent.add(getPopupMenu());
    }
    
    public function show(origin:Component, x:Integer, y:Integer) {
        getPopupMenu().show(origin, x, y);
    }
    
    public function getPopupMenu():PopupMenu {
        return getMenuItem() as PopupMenu;
    }

    protected function createMenuItem():MenuItem {
        return PopupMenu{};
    }
}

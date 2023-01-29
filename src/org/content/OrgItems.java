package org.content;

import arc.graphics.*;
import arc.struct.*;
import mindustry.*;
import mindustry.game.*;
import mindustry.graphics.*;
import mindustry.type.*;

import static mindustry.content.Items.*;

public class OrgItems {
  public static Item calcium, carbon, chitin, phosphorus, resin, tissue;
  
  public static void load() {
    calcium  = new Item("calcium", Color.valueOf("ffffff")) {{
      hardness = 1;
      alwaysUnlocked = true;
    }};
    
    carbon = new Item("carbon", Color.valueOf("3c3838") {{
      hardness = 0;
      alwaysUnlocked = true;
    }};
    
    chitin = new Item("chitin", Color.valueOf("ebeef5") {{
      hardness = 3;
    }};
    
    phosphorus = new Item("phosphorus", Color.valueOf("742222") {{
      hardness = 2;
      flammability = 1.5f;
      explosiveness = 0.0005f;
    }};
                          
    resin = new Item("resin", Color.valueOf("eac629") {{
      flammability = 0.05f;
      charge = 0.2f;
    }};
    
    tissue = new Item("tissue", Color.valueOf("999781") {{
      flammability = 0.2f;
      hardness = 2;
    }};
    
    serpuloItems.addAll(
      calcium, carbon, chitin, phosphorus, resin, tissue
     );                
  }
}

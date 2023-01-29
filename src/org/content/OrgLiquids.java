package org.content;

import arc.*;
import arc.graphics.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.game.*;
import mindustry.graphics.*;
import mindustry.type.*;

import static mindustry.content.Liquids.*;


public class OrgLiquids {
  public static Liquid energia, clorine, liquidResin;
  
  public static void load() {
    blood = new Liquid("energia", Color.valueOf("fb9567")) {{
      temperature = 0.6f;
      viscosity = 0.9f;
      lightColor = Color.valueOf("fb7165");
    }};
    
    liquidResin = new Liquid("liquidResin", Color.valueOf("eac629")) {{
      temperature = 0.3f;
      viscosity = 0.1f;
      lightColor = Color.valueOf("ffd414");
    }};
  }
}

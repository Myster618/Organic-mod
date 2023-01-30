package org.content;

import arc.graphics.*;
import arc.math.*;
import arc.struct.*;
import org.*;
import mindustry.content.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.entities.part.*;
import mindustry.entities.pattern.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.production.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;


public class OrgBlocks {
  public static Block
    //environment
    calciteOre, carbonFloor, carbonWall, carbonOre, chitinOre, energiaCrater, 
    energiaPuddle, fleshFloor, fleshWall, plantFloor, plantWall, 
    shallowEnergia, deepEnergia,
    //decorations
    boulderGreen, boulderRed, boulderBlack, sproutLightgreen, sproutDarkgreen,
    //turrets
    bloodlust, jet, minigun, needle, mender, sower,
    //walls
    carbonWall, carbonWallLarge, chitinWall, chitinWallLarge, resinWall, resinWallLarge,
    //production
    creciteDrill, chinitDrill, resinExtractor,
    //storage
    reservoir,
    //cores
    coreSprout,
    //power
    beamNode, bioBattery, bioGenerator, heatAbsorber, heatConcentrator, powerNode,
    //craft
    bioweaver, energiaCompressor, energiaConverter, phosphorSeparator, vulcanizer,
    //liquid
    barrel, biobridge, bioconduit, liqjunction, peristalsisPump,
    //distribution
    carbonJunction, carbonRouter, overflow, underflow, carbonConveyor, carbonBridge,
    //effect
    flash, trap,
    //units
    nestRecT1, nestRecT2, nestRecT3;
  
  
  
  public static void load() {
    
    calciteOre = new OreBlock(OrgItems.calcite);
    
    carbonOre = new OreBlock(OrgItems.carbon);
    
    chitinOre = new OreBlock(OrgItems.chitin);
    
    carbonFloor = new Floor("carbon-floor") {{
      ItemDrop = OrgItems.carbon;
    }};
    
    carbonWall = new StaticWall("carbon-wall") {{
      carbonFloor.asFloor().wall = this;
    }};
    
    energiaCrater = new Floor("energia-crater") {{
      attributes.set(Attribute.heat, 1f);
      blendGroup = basalt;
      emitLight = true;
      lightRadius = 50f;
      lightColor = Color.orange.cpy().a(0.3f);
    }};
    
    energiaPuddle = new Floor("energia-puddle") {{
      attributes.set(Attribute.heat, 0.75f);
      blendGroup = basalt;
      emitLight = true;
      lightRadius = 30f;
      lightColor = Color.orange.cpy().a(0.15f);
    }};
      
    fleshFloor = new Floor("flesh-floor");
    
    fleshWall = new StaticWall("flesh-wall") {{
      fleshFloor.asFloor().wall = this;
    }};
    
    plantFloor = new Floor("plant-floor");
    
    plantWall = new StaticWall("plant-wall") {{
      plantFloor.asFloor().wall = this;
    }};
  }
}

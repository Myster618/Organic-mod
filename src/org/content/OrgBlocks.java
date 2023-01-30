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
    calciumOre, carbonFloor, carbonBlock, carbonOre, chitinOre, energiaCrater, 
    energiaPuddle, fleshFloor, fleshBlock, plantFloor, plantBlock, 
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
    
    calciumOre = new OreBlock(OrgItems.calcium);
    
    carbonOre = new OreBlock(OrgItems.carbon);
    
    chitinOre = new OreBlock(OrgItems.chitin);
    
    carbonFloor = new Floor("carbon-floor") {{
      itemDrop = OrgItems.carbon;
    }};
    
    carbonBlock = new StaticWall("carbon-block") {{
      carbonFloor.asFloor().wall = this;
    }};
    
    energiaCrater = new Floor("energia-crater") {{
      attributes.set(Attribute.heat, 1f);
      emitLight = true;
      lightRadius = 50f;
      lightColor = Color.orange.cpy().a(0.3f);
    }};
    
    energiaPuddle = new Floor("energia-puddle") {{
      attributes.set(Attribute.heat, 0.75f);
      emitLight = true;
      lightRadius = 30f;
      lightColor = Color.orange.cpy().a(0.15f);
    }};
      
    fleshFloor = new Floor("flesh-floor");
    
    fleshBlock = new StaticWall("flesh-block") {{
      fleshFloor.asFloor().wall = this;
    }};
    
    plantFloor = new Floor("plant-floor");
    
    plantBlock = new StaticWall("plant-block") {{
      plantFloor.asFloor().wall = this;
    }};
    
    shallowEnergia = new Floor("shallow-energia") {{
      speedMultiplier = 0.75f;
      variants = 0;
      albedo = 0.9f;
      isLiquid = true;
      liquidDrop = OrgLIquids.energia;
      cacheLayer = CacheLayer.water;
      supportsOverlay = true;
    }};
    
    deepEnergia = new Floor("deep-energia") {{
      speedMultiplier = 0.5f;
      variants = 0;
      liquidMultiplier = 1.5f;
      albedo = 0.9f;
      drownTime = 300f;
      isLiquid = true;
      liquidDrop = OrgLIquids.energia;
      cacheLayer = CacheLayer.water;
      supportsOverlay = true;
    }};
  }
}

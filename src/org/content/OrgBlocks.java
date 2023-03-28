package org.content;

import arc.graphics.*;
import arc.math.*;
import arc.struct.*;
import mindustry.*;
import mindustry.entities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.entities.part.*;
import mindustry.entities.pattern.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.world.*;
import org.*;
import org.world.meta.*;
import org.world.blocks.storage.*;
import mindustry.content.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.storage.*;
import mindustry.world.blocks.power.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;


public class OrgBlocks {
  public static Block
    //environment
    calciumOre, carbonFloor, carbonBlock, carbonOre, chitinOre, energiaCrater, 
    energiaPuddle, fleshFloor, fleshBlock, plantFloor, plantBlock, 
    shallowEnergia, deepEnergia, resinFloor, resinBlock, muddySand, squama, squamaPlate,
    muddySandBlock, wallOreCalcium, Coral,
    //decorations
    boulderSquama, boulderRed, boulderBlack, tree, treeFruits, treeDead, resinOutgrowth, 
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
    
    wallOreCalcium = new OreBlock("wall-ore-calcium", OrgItems.calcium) {{
      wallOre = true;
    }};
    
    Coral = new StaticWall("coral-block") {{
      itemDrop = OrgItems.coral;
    }};
    
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
      fleshFloor.asFloor().wall = energiaPuddle.asFloor().wall = energiaCrater.asFloor().wall = this;
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
      liquidDrop = OrgLiquids.energia;
      cacheLayer = CacheLayer.water;
      supportsOverlay = true;
    }};
    
    deepEnergia = new Floor("deep-energia") {{
      speedMultiplier = 0.25f;
      variants = 0;
      liquidMultiplier = 1.5f;
      albedo = 0.9f;
      drownTime = 300f;
      isLiquid = true;
      liquidDrop = OrgLiquids.energia;
      cacheLayer = CacheLayer.water;
      supportsOverlay = true;
    }};
    
    resinFloor = new Floor("resin-floor") {{
      speedMultiplier = 0.2f;
      attributes.set(OrgAttribute.resin, 0.75f);
      attributes.set(Attribute.water, -0.25f);
    }};
    
    resinBlock = new StaticWall("resin-block") {{
      resinFloor.asFloor().wall = this;
    }};
    
    muddySand = new Floor("muddy-sand") {{
      speedMultiplier = 0.2f;
      itemDrop = Items.sand;
      playerUnmineable = true;
      attributes.set(OrgAttribute.resin, 0.15f);
      attributes.set(Attribute.water, 0.75f);
    }};

    muddySandBlock = new StaticWall("muddy-sand-block") {{
      muddySand.asFloor().wall = this;
    }};
    
    squama = new Floor("squama") {{
      attributes.set(OrgAttribute.resin, 0.25f);
      attributes.set(Attribute.water, -0.25f);
    }};
    
    squamaPlate = new Floor("squama-plate") {{
      attributes.set(OrgAttribute.resin, 0.15f);
      attributes.set(Attribute.water, -0.25f);
    }};
    
    boulderRed = new Prop("flesh-boulder") {{
      variants = 2;
      fleshFloor.asFloor().decoration = energiaPuddle.asFloor().decoration = energiaCrater.asFloor().decoration = this;
    }};

    boulderBlack = new Prop("carbon-boulder") {{
      variants = 2;
      carbonFloor.asFloor().decoration = this;
    }};
    
    boulderSquama = new Prop("squama-boulder") {{
      variants = 2;
      squama.asFloor().decoration = squamaPlate.asFloor().decoration = this;
    }};
    tree = new Prop("tree");

    treeFruits = new Prop("tree-fruits");

    treeDead = new Prop("tree-dead");

    resinOutgrowth = new Prop("resin-outgrowth") {{
      resinFloor.asFloor().decoration = this;
      variants = 2;
    }};
    
    coreSprout = new SolarCore("core-sprout") {{
      requirements(Category.effect, ItemStack.with(OrgItems.carbon, 1200, OrgItems.chitin, 1000, OrgItems.phosphorus, 600));
      powerProduction = 10f;
      alwaysUnlocked = true;
      isFirstTier = true;
      unitType = UnitTypes.alpha;
      unitCapModifier = 6;
      itemCapacity = 3000;
      health = 2000;
      size = 3;
    }};
    heatAbsorber = new ThermalGenerator("heat-absorber"){{
      requirements(Category.power, ItemStack.with(OrgItems.carbon, 30, OrgItems.chitin, 20));
      powerProduction = 0.5f;
      generateEffect = Fx.redgeneratespark;
      effectChance = 0.011f;
      size = 1;
      floating = true;
      ambientSound = Sounds.hum;
      ambientSoundVolume = 0.03f;
    }};
    heatConcentrator = new ThermalGenerator("heat-concentrator"){{
      requirements(Category.power, ItemStack.with(OrgItems.carbon, 30, OrgItems.chitin, 20));
      powerProduction = 2.5f;
      generateEffect = Fx.redgeneratespark;
      drawer = new DrawMulti(
        new DrawRegion("-bottom"),
        new DrawGlowRegion("-glow") {{
          color = Color.valueOf("fa9566");
          glowIntensity = 0.3f;
        }}, 
        new DrawParticles(){{
          color = Color.valueOf("fae5b1");
          alpha = 0.8f;
          particleSize = 1f;
          particles = 23;
          particleRad = 6f;
          particleLife = 40f;
          rotateScl = 4;
          fadeMargin = 1;
        }}, 
        new DrawDefault());
      effectChance = 0.011f;
      size = 2;
      floating = true;
      ambientSound = Sounds.hum;
      ambientSoundVolume = 0.06f;
    }};
  }
}

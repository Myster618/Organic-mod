package org.world.blocks.storage;

import arc.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import org.*;
import mindustry.*;
import mindustry.game.*;
import mindustry.graphics.*;
import mindustry.graphics.MultiPacker.*;
import mindustry.world.blocks.storage.*;
import arc.struct.*;
import arc.util.*;
import arc.util.io.*;
import mindustry.entities.units.*;
import mindustry.gen.*;
import mindustry.ui.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;

import static mindustry.Vars.*;

public class SolarCore extends CoreBlock {
  public float powerProduction;
  public Stat generationType = Stat.basePowerGeneration;
  
  public SolarCore(String name) {
    super(name);
    hasPower = true;
    consumesPower = false;
    outputsPower = true;
  }
  
  @Override
  public void setStats() {
    super.setStats();
    stats.remove(generationType);
    stats.add(generationType, powerProduction * 60.0f, StatUnit.powerSecond);
  }
  
  @Override
  public void setBars(){
     super.setBars();
     if(hasPower && outputsPower){
            addBar("power", (SolarCoreBuild entity) -> new Bar(() ->
            Core.bundle.format("bar.poweroutput",
            Strings.fixed(entity.getPowerProduction() * 60 * entity.timeScale(), 1)),
            () -> Pal.powerBar,
            () -> entity.productionEfficiency));
        }
    }
  
  public class SolarCoreBuild extends CoreBuild {
    public float generateTime;
    public float productionEfficiency = 0.0f;
    
    @Override
    public float getPowerProduction() {
      return powerProduction * productionEfficiency;
    }
    
     @Override
     public void updateTile() {
         productionEfficiency = enabled ?
             Mathf.maxZero(Attribute.light.env() +
                 (state.rules.lighting ?
                     1f - state.rules.ambientLight.a :
                     1f
                 )) : 0f;
     }
    
     @Override
     public void write(Writes write){
         super.write(write);
         write.f(productionEfficiency);
         write.f(generateTime);
     }

     @Override
     public void read(Reads read, byte revision){
         super.read(read, revision);
         productionEfficiency = read.f();
         if(revision >= 1){
             generateTime = read.f();
         }
     }  
  }
}

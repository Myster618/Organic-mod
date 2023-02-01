package org.world.meta;

import arc.*;
import mindustry.game.EventType.*;
import mindustry.world.meta.*;

import static mindustry.content.Blocks.*;

public class OrgAttribute {
  public static final Attribute resin = Attribute.add("resin");
  //adding attribute to vanilla content
  static {
    Events.run(ContentInitEvent.class, () -> {
      sand.attributes.set(resin, 0.2f);
    });  
  }
}

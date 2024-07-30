/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tea.map.zones;

import com.tea.ability.AbilityCustom;
import com.tea.bot.attack.AttackAround;
import com.tea.bot.move.MoveWithinCustom;
import com.tea.bot.Bot;
import com.tea.fashion.FashionCustom;
import com.tea.map.Map;
import com.tea.map.TileMap;
import com.tea.model.Char;
import com.tea.skill.SkillFactory;
import com.tea.constants.SkillName;

/**
 *
 * @author Admin
 */
public class HirosakiGymnasium extends Gymnasium {

    public HirosakiGymnasium(int id, TileMap tilemap, Map map) {
        super(id, tilemap, map);
    }

    @Override
    public void initBot() {
        Bot bot = Bot.builder().id(-11111).name("Cô Toyotomi")
                .level(50)
                .typePk(Char.PK_DOSAT)
                .build();
        bot.setDefault();
        FashionCustom fashionCustom = FashionCustom.builder()
                .head((short) 44)
                .body((short) 45)
                .leg((short) 46)
                .weapon((short) -1)
                .build();
        bot.setFashionStrategy(fashionCustom);
        AbilityCustom abilityCustom = AbilityCustom.builder()
                .hp(1000)
                .mp(1000)
                .damage(1000)
                .damage2(900)
                .miss(10)
                .exactly(100)
                .fatal(100)
                .build();
        bot.setAbilityStrategy(abilityCustom);
        MoveWithinCustom move = MoveWithinCustom.builder()
                .minX(744)
                .maxX(1176)
                .minY(100)
                .maxY(240)
                .build();
        bot.setMove(move);
        AttackAround attackAround = new AttackAround();
        attackAround.addSkill(SkillFactory.getInstance().newSkill(SkillName.CHIEU_CHOUKOUHIRENZO, 1));
        attackAround.addSkill(SkillFactory.getInstance().newSkill(SkillName.CHIEU_CHOUKOU_SHURIKEN, 1));
        bot.setAttack(attackAround);
        bot.setAbility();
        bot.setFashion();
        bot.recovery();
        bot.setXY((short) 1000, (short) 240);
        setBot(bot);
        join(bot);
    }

}

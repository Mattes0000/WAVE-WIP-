package com.mattes.wave;




public class PlaySoundATGameState {

    Sound sound = new Sound();
    Game game = new Game();


    PlaySoundATGameState() {
        if (Game.gameState == Game.STATE.Menu || Game.gameState == Game.STATE.SelectMode || Game.gameState == Game.STATE.Select ||
            Game.gameState == Game.STATE.Selectlvl1 ||Game.gameState == Game.STATE.Selectlvl2|| Game.gameState == Game.STATE.Settings||
            Game.gameState == Game.STATE.Credits || Game.gameState == Game.STATE.Help) {
            PlaySongAt(3);
        }
        if (Game.gameState == Game.STATE.Game ||Game.gameState == Game.STATE.Shop ) {
            PlaySongAt(2);
        }
    }

    private void PlaySongAt(int i) {

        sound.setFile(i);
        sound.play();
        sound.loop();

    }

}

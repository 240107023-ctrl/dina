public class Task11Adapter implements ModernAudioPlayer {
    private final OldMediaEngine oldEngine;

    public Task11Adapter(OldMediaEngine oldEngine) {
        this.oldEngine = oldEngine;
    }

    @Override
    public void playTrack(AudioTrack track) {
        if (track == null) return;
        oldEngine.startPlayback(track.getFilePath(), (int) track.getDurationSeconds());
    }
}
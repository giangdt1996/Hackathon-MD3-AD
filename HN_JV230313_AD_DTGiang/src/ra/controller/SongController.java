package ra.controller;

import ra.model.Singer;
import ra.model.Song;
import ra.service.SongService;
import ra.service.SingerService;

import java.util.List;
import java.util.Scanner;

public class SongController {
    private SongService songService;
    private SingerService singerService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    public SongController(SongService songService, SingerService singerService) {
        this.songService = songService;
        this.singerService = singerService;
    }

    public void addSong() {
        Song song = new Song();
        song.inputData();
        songService.addSong(song);
        System.out.println("Thêm bài hát thành công.");
    }

    public void displayAllSongs() {
        Song[] allSongs = songService.getAllSongs().toArray(new Song[0]);

        if (allSongs.length == 0) {
            System.out.println("Không có bài hát nào.");
        } else {
            System.out.println("Danh sách tất cả bài hát:");
            for (Song song : allSongs) {
                song.displayData();
                System.out.println("------------------------");
            }
        }
    }

    public void updateSong() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập ID bài hát muốn cập nhật: ");
        String songId = scanner.nextLine();

        Song song = songService.findSongById(songId);
        if (song != null) {
            song.inputData();
            songService.updateSong(song);
            System.out.println("Cập nhật bài hát thành công.");
        } else {
            System.out.println("Không tìm thấy bài hát.");
        }
    }

    public void deleteSong() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập id bài hát muốn xóa: ");
        String songId = scanner.nextLine();

        Song song = songService.findSongById(songId);
        if (song != null) {
            songService.deleteSong(songId);
            System.out.println("Xóa bài hát thành công.");
        } else {
            System.out.println("Không tìm tháy bài hát.");
        }
    }

    public void searchSongsByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên bài hát: ");
        String keyword = scanner.nextLine();

        List<Song> searchResults = songService.searchSongsByName(keyword);
        if (searchResults.isEmpty()) {
            System.out.println("Không tìm thấy bài hát nào có tên chứa từ khóa: " + keyword);
        } else {
            System.out.println("Kết quả tìm kiếm:");
            for (Song song : searchResults) {
                System.out.println("Mã ID: " + song.getSongId());
                System.out.println("Tên bài hát: " + song.getSongName());
                System.out.println("Ca sĩ: " + song.getSinger());
                System.out.println("Nhạc sĩ: " + song.getSongWriter());
                System.out.println("***************************");
            }
        }
    }




}
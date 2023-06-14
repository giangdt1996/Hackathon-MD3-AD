package ra.model;

import java.util.Date;
import java.util.Scanner;

public class Song {
    private String songId;
    private String songName;
    private String descriptions;
    private String singer;
    private String songWriter;
    private Date createdDate;
    private boolean songStatus;

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getSongWriter() {
        return songWriter;
    }

    public void setSongWriter(String songWriter) {
        this.songWriter = songWriter;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isSongStatus() {
        return songStatus;
    }

    public void setSongStatus(boolean songStatus) {
        this.songStatus = songStatus;
    }
    public void inputData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập mã bài hát (4 ký tự, bắt đầu bằng S): ");
        String id = scanner.nextLine();
        while (id.length() != 4 || !id.startsWith("S")) {
            System.out.println("Mã bài hát không hợp lệ! Vui lòng nhập lại.");
            System.out.print("Nhập mã bài hát (4 ký tự, bắt đầu bằng S): ");
            id = scanner.nextLine();
        }
        this.songId = id;

        System.out.print("Nhập tên bài hát: ");
        this.songName = scanner.nextLine();

        System.out.print("Nhập mô tả bài hát: ");
        this.descriptions = scanner.nextLine();
        System.out.print("Nhập tên ca sĩ: ");
        this.singer = scanner.nextLine();


        System.out.print("Nhập tên người sáng tác: ");
        this.songWriter = scanner.nextLine();

        System.out.print("Nhập trạng thái: ");
        System.out.println("1.Khả dụng");
        System.out.println("2.Không khả dụng");
        int choice2 = scanner.nextInt();
        switch (choice2) {
            case 1:
                setSongStatus(true);
                break;
            case 2:
                setSongStatus(false);
                break;
            default:
                System.out.println("Vui lòng chọn 1 hoặc 2");
        }
    }

    public void displayData() {
        System.out.println("Mã bài hát: " + songId);
        System.out.println("Tên bài hát: " + songName);
        System.out.println("Mô tả: " + descriptions);
        System.out.println("Ca sĩ trình bày: " + singer);
        System.out.println("Người sáng tác: " + songWriter);
        System.out.println("Ngày tạo: " + createdDate);
        System.out.println("Trạng thái: " + (songStatus ? "Có sẵn" : "Hết"));
    }
}

package com.feelthebeats.js.ftb2om;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class ConverterMain {

    public static final String ERROR_ARGUMENTS = "Required arguments: [input file] [output file] [BPM]";
    public static final String ERROR_IO = "ERROR: File not found, or error opening file.";

    public static final String MSG_GREET = "ftb->osumania converter by JS. js.nexen@gmail.com";
    public static final String MSG_SCANNING = "Scanning input file...";
    public static final String MSG_SCANNING_DONE = "Done scanning. Generating converted text...";
    public static final String MSG_DONE = "Done! Now make a new file in osu if you haven't already, and paste the text in.";

    private static File inFile;
    private static File outFile;
    private static BufferedReader reader;
    private static PrintWriter writer;

    private static double mainBpm;

    private static Queue<BPM> bpms;
    private static Queue<Note> notes;

    public static void main(String[] args) {
        System.out.println(MSG_GREET);
        bpms = new LinkedList<BPM>();
        notes = new LinkedList<Note>();
        if (args.length != 3) {
            System.out.println(ERROR_ARGUMENTS);
        } else {
            inFile = new File(args[0]);
            outFile = new File(args[1]);
            mainBpm = Double.parseDouble(args[2]);
            try {
                reader = new BufferedReader(new FileReader(inFile));
                writer = new PrintWriter(outFile);
                System.out.println(MSG_SCANNING);
                String readLine;
                while ((readLine = reader.readLine()) != null) {
                    if (readLine.startsWith("###"))
                        continue;
                    else if (readLine.startsWith("BPM")) {
                        String[] bpmData = readLine.split(" ");
                        bpms.add(new BPM(
                                Integer.parseInt(bpmData[1]),
                                mainBpm * Double.parseDouble(bpmData[2]) / 120
                        ));
                    } else {
                        String[] noteData = readLine.split(" ");
                        String noteTime = (noteData[0].split("-"))[0];
                        notes.add(new Note(
                                (int) Math.round(Double.parseDouble(noteTime)),
                                Integer.parseInt(noteData[2])
                        ));
                    }
                }
                System.out.println(MSG_SCANNING_DONE);
                writer.println("[TimingPoints]");
                while (!bpms.isEmpty()) {
                    BPM bpm = bpms.remove();
                    writer.println(bpm.getTime() + "," + 60000 / bpm.getValue() + ",4,1,0,100,1,0");
                }
                writer.println();
                writer.println("[HitObjects]");
                while (!notes.isEmpty()) {
                    Note note = notes.remove();
                    int noteX = (512 / 14) * ((note.getColumn() - 1) * 2 + 1);
                    int noteY = 192;
                    writer.println(noteX + "," + noteY + "," + note.getTime() + ",1,0");
                }
                writer.close();
                reader.close();
                System.out.println(MSG_DONE);
            } catch (IOException e) {
                System.out.println(ERROR_IO);
            }
        }
    }
}

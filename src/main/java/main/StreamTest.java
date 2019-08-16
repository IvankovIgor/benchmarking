package main;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.stream.Stream;

public class StreamTest {

    private void stream() {
        try {
            final StringBuilder pewLine = new StringBuilder();
            Files.lines(Path.of("/home/ivankov/Downloads/pmta-dkim3.txt")).map(
                    s -> {
                        String[] split = s.split(",");
                        if (split.length != 3 || split[0].startsWith("domain-key ")) {
                            //  LOGGER.warn("Invalid row. Skip thsi " + s);
                            return null;
                        }
                        pewLine.setLength(0);
                        pewLine.append(s);
//                        return new DkimRecord(split[0].trim().replace("domain-key ", ""), split[1].trim(), split[2].trim());
                        return split[0].trim().replace("domain-key ", "");
                    }).filter(Objects::nonNull).forEach(dkimRecord -> {
            });
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public void loadWithFor() {
        try {
            Stream<String> lines = Files.lines(Path.of("/home/ivankov/Downloads/pmta-dkim3.txt"));
            String pewLine = "";

            for (String line : (Iterable<String>) lines::iterator) {

                String[] split = line.split(",");
                if (split.length != 3 || !split[0].startsWith("domain-key ")) {
                    //  LOGGER.warn("Invalid row. Skip thsi " + s);
                    continue;
                }

                pewLine = line;
                //    LOGGER.info(new DkimRecord(split[0].trim().replace("domain-key ", ""), split[1].trim(), split[2].trim()).toString());
                split[0].trim().replace("domain-key ", "");


            }

        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}

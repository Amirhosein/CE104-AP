package src;

import java.util.Scanner;

public class Main {
    public static void menu() {
        System.out.print("1. Add music\n2. Count\n3. List\n4. Remove from List\n5. Play Music\n6. Stop Playing\n7. Favorite's section\n8. Search\n");
    }

    public static void favorite() {
        System.out.print("1. Add track\n2. Remove track\n3. List\n");
    }

    public static void main(String[] args) {
        MusicCollection pop = new MusicCollection();
        MusicCollection jazz = new MusicCollection();
        MusicCollection rock = new MusicCollection();
        MusicCollection country = new MusicCollection();
        String name;
        String singer;
        int choose;
        int release;
        Scanner input = new Scanner(System.in);
        while (true) {
            menu();
            choose = input.nextInt();

            if (choose == 1) {
                System.out.println("Please enter type:");
                input.nextLine();
                name = input.nextLine();
                if (name.equalsIgnoreCase("pop")) {
                    System.out.println("Please enter name:");
                    name = input.nextLine();
                    System.out.println("Please enter singer's name:");
                    singer = input.nextLine();
                    System.out.println("Please enter release date:");
                    release = input.nextInt();
                    pop.addFile(name, singer, release);
                } else if (name.equalsIgnoreCase("jazz")) {
                    System.out.println("Please enter name:");
                    name = input.nextLine();
                    System.out.println("Please enter singer's name:");
                    singer = input.nextLine();
                    System.out.println("Please enter release date:");
                    release = input.nextInt();
                    jazz.addFile(name, singer, release);
                } else if (name.equalsIgnoreCase("rock")) {
                    System.out.println("Please enter name:");
                    name = input.nextLine();
                    System.out.println("Please enter singer's name:");
                    singer = input.nextLine();
                    System.out.println("Please enter release date:");
                    release = input.nextInt();
                    rock.addFile(name, singer, release);
                } else if (name.equalsIgnoreCase("country")) {
                    System.out.println("Please enter name:");
                    name = input.nextLine();
                    System.out.println("Please enter singer's name:");
                    singer = input.nextLine();
                    System.out.println("Please enter release date:");
                    release = input.nextInt();
                    country.addFile(name, singer, release);
                }

            } else if (choose == 2) {
                System.out.println("Please enter type:");
                input.nextLine();
                name = input.nextLine();
                if (name.equalsIgnoreCase("pop")) {
                    System.out.println(pop.getNumberOfFiles() + " songs in this type.");
                } else if (name.equalsIgnoreCase("jazz")) {
                    System.out.println(jazz.getNumberOfFiles() + " songs in this type.");
                } else if (name.equalsIgnoreCase("rock")) {
                    System.out.println(rock.getNumberOfFiles() + " songs in this type.");
                } else if (name.equalsIgnoreCase("country")) {
                    System.out.println(country.getNumberOfFiles() + " songs in this type.");
                }
            } else if (choose == 3) {
                System.out.println("Please enter type:");
                input.nextLine();
                name = input.nextLine();
                if (name.equalsIgnoreCase("pop")) {
                    pop.listAllFiles();
                } else if (name.equalsIgnoreCase("jazz")) {
                    jazz.listAllFiles();
                } else if (name.equalsIgnoreCase("rock")) {
                    rock.listAllFiles();
                } else if (name.equalsIgnoreCase("country")) {
                    country.listAllFiles();
                }
            } else if (choose == 4) {
                System.out.println("Please enter type:");
                input.nextLine();
                name = input.nextLine();
                if (name.equalsIgnoreCase("pop")) {
                    pop.listAllFiles();
                    System.out.println("Please enter index:");
                    choose = input.nextInt();
                    pop.removeFile(choose);
                } else if (name.equalsIgnoreCase("jazz")) {
                    jazz.listAllFiles();
                    System.out.println("Please enter index:");
                    choose = input.nextInt();
                    jazz.removeFile(choose);
                } else if (name.equalsIgnoreCase("rock")) {
                    rock.listAllFiles();
                    System.out.println("Please enter index:");
                    choose = input.nextInt();
                    rock.removeFile(choose);
                } else if (name.equalsIgnoreCase("country")) {
                    country.listAllFiles();
                    System.out.println("Please enter index:");
                    choose = input.nextInt();
                    country.removeFile(choose);

                }
            } else if (choose == 5) {
                System.out.println("Please enter type:");
                input.nextLine();
                name = input.nextLine();
                if (name.equalsIgnoreCase("pop")) {
                    pop.listAllFiles();
                    System.out.println("Please enter index:");
                    choose = input.nextInt();
                    pop.startPlaying(choose);
                } else if (name.equalsIgnoreCase("jazz")) {
                    jazz.listAllFiles();
                    System.out.println("Please enter index:");
                    choose = input.nextInt();
                    jazz.startPlaying(choose);
                } else if (name.equalsIgnoreCase("rock")) {
                    rock.listAllFiles();
                    System.out.println("Please enter index:");
                    choose = input.nextInt();
                    rock.startPlaying(choose);
                } else if (name.equalsIgnoreCase("country")) {
                    country.listAllFiles();
                    System.out.println("Please enter index:");
                    choose = input.nextInt();
                    country.startPlaying(choose);
                }

            } else if (choose == 6) {
                System.out.println("Please enter type:");
                input.nextLine();
                name = input.nextLine();
                if (name.equalsIgnoreCase("pop")) {
                    pop.stopPlaying();
                } else if (name.equalsIgnoreCase("jazz")) {
                    jazz.stopPlaying();
                } else if (name.equalsIgnoreCase("rock")) {
                    rock.stopPlaying();
                } else if (name.equalsIgnoreCase("country")) {
                    country.stopPlaying();
                }
            } else if (choose == 7) {
                while (true) {
                    favorite();
                    System.out.println("Please choose:");
                    choose = input.nextInt();
                    if (choose == 1) {
                        System.out.println("Please enter type:");
                        input.nextLine();
                        name = input.nextLine();
                        if (name.equalsIgnoreCase("pop")) {
                            pop.listAllFiles();
                            System.out.println("Please enter index:");
                            choose = input.nextInt();
                            pop.addTrackToFavorite(choose);

                        } else if (name.equalsIgnoreCase("jazz")) {
                            jazz.listAllFiles();
                            System.out.println("Please enter index:");
                            choose = input.nextInt();
                            jazz.addTrackToFavorite(choose);
                        } else if (name.equalsIgnoreCase("rock")) {
                            rock.listAllFiles();
                            System.out.println("Please enter index:");
                            choose = input.nextInt();
                            rock.addTrackToFavorite(choose);
                        } else if (name.equalsIgnoreCase("country")) {
                            country.listAllFiles();
                            System.out.println("Please enter index:");
                            choose = input.nextInt();
                            country.addTrackToFavorite(choose);

                        }
                    } else if (choose == 3) {
                        System.out.println("Please enter type:");
                        input.nextLine();
                        name = input.nextLine();
                        if (name.equalsIgnoreCase("pop")) {
                            pop.allFavoriteTracks();
                        } else if (name.equalsIgnoreCase("jazz")) {
                            jazz.allFavoriteTracks();
                        } else if (name.equalsIgnoreCase("rock")) {
                            rock.allFavoriteTracks();
                        } else if (name.equalsIgnoreCase("country")) {
                            country.allFavoriteTracks();
                        }
                    } else if (choose == 2){
                        System.out.println("Please enter type:");
                        input.nextLine();
                        name = input.nextLine();
                        if (name.equalsIgnoreCase("pop")) {
                            pop.allFavoriteTracks();
                            System.out.println("Please enter index:");
                            choose = input.nextInt();
                            pop.removeTrackFromFavorite(choose);
                        } else if (name.equalsIgnoreCase("jazz")) {
                            jazz.allFavoriteTracks();
                            System.out.println("Please enter index:");
                            choose = input.nextInt();
                            jazz.removeTrackFromFavorite(choose);
                        } else if (name.equalsIgnoreCase("rock")) {
                            rock.allFavoriteTracks();
                            System.out.println("Please enter index:");
                            choose = input.nextInt();
                            rock.removeTrackFromFavorite(choose);
                        } else if (name.equalsIgnoreCase("country")) {
                            country.allFavoriteTracks();
                            System.out.println("Please enter index:");
                            choose = input.nextInt();
                            country.removeTrackFromFavorite(choose);
                        }
                    }
                    else
                        break;

                }
            }
            else if (choose == 8){
                System.out.println("Please enter type:");
                input.nextLine();
                name = input.nextLine();
                if (name.equalsIgnoreCase("pop")) {
                    name = input.nextLine();
                    pop.search(name);
                } else if (name.equalsIgnoreCase("jazz")) {
                    name = input.nextLine();
                    jazz.search(name);
                } else if (name.equalsIgnoreCase("rock")) {
                    name = input.nextLine();
                    rock.search(name);
                } else if (name.equalsIgnoreCase("country")) {
                    name = input.nextLine();
                    country.search(name);
                }
            }
        }
    }
}

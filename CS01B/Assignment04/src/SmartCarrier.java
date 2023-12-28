import java.io.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.util.*;
import java.util.Map.Entry;

public class SmartCarrier
{
    private TreeMap<String, ArrayList<Item>> map;
    private String location;

    public SmartCarrier()
    {
        map = new TreeMap<String, ArrayList<Item>>();
        location = "Alameda County";
    }

    public SmartCarrier(String location)
    {
        map = new TreeMap<String, ArrayList<Item>>();
        this.location = location;
    }

    public void init()
    {
        String line;
        String[] data;
        int time;
        String from;
        String to;
        String filePath= "/Users/w.li/eclipse-workspace/CS1B/Assignments/Assignment04/MessageData.txt";

        Path fileLocation = Paths.get(filePath);
        try (BufferedReader br = Files.newBufferedReader(fileLocation, StandardCharsets.UTF_8))
        {
            while ((line = br.readLine()) != null)
            {
                data = line.split(",");
                time = Integer.parseInt(data[1]);
                from = data[2];
                to = data[3];

                if (data[0].equalsIgnoreCase("T"))
                {
                    Text text = new Text(data[4]);
                    Message<Text> message = new Message<Text>(text, time, from, to, text.charge());
                    if (map.containsKey(from))
                    {

                        map.get(from).add(message);
                    } else
                    {
                        map.put(from, new ArrayList<Item>());
                        map.get(from).add(message);
                    }
                } else if (data[0].equalsIgnoreCase("M"))
                {
                    Media media = new Media(Double.parseDouble(data[4]), data[5]);
                    Message<Media> message = new Message<Media>(media, time, from, to, media.charge());
                    if (map.containsKey(from))
                    {
                        map.get(from).add(message);
                    } else
                    {
                        map.put(from, new ArrayList<Item>());
                        map.get(from).add(message);
                    }
                } else if (data[0].equalsIgnoreCase("V"))
                {
                    Voice voice = new Voice(Integer.parseInt(data[4]), data[5]);
                    Message<Voice> message = new Message<Voice>(voice, time, from, to, voice.charge());
                    if (map.containsKey(from))
                    {
                        map.get(from).add(message);
                    } else
                    {
                        map.put(from, new ArrayList<Item>());
                        map.get(from).add(message);
                    }
                }
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public void run()
    {
        try
        {
            boolean isUsing = true;
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int userChoice;
            do
            {
                printMenu();
                userChoice = Integer.parseInt(reader.readLine());
                switch (userChoice)
                {
                case 1:
                    listAccounts();
                    break;
                case 2:
                    eraseFirst();
                    break;
                case 3:
                    equalsTest(reader);
                    break;
                case 4:
                    quit(reader);
                    isUsing = false;
                    break;
                default:
                    System.out.println("Please enter a valid menu choice");
                    break;
                }
            } while (isUsing);
        } catch (NumberFormatException n)
        {
            System.out.println("Please enter a valid menu choice");
        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    private void equalsTest(BufferedReader reader) throws IOException
    {
        String messageType;
        int messageTime;
        String from;
        String to;
        try
        {
            Message<?> message1 = null;
            Message<?> message2 = null;
            System.out.println("\nEquals test - please enter message specifics\n");
            System.out.println("Message 1:\nMessage type (Text, Voice, Media):");
            messageType = reader.readLine();
            System.out.println("Message time (secs from 1/1/1970):");
            messageTime = Integer.parseInt(reader.readLine());
            System.out.println("Sending number:");
            from = reader.readLine();
            System.out.println("Receiving number:");
            to = reader.readLine();
            if (messageType.equalsIgnoreCase("Text"))
            {
                System.out.println("Text message content");
                String content = reader.readLine();
                Text text = new Text(content);
                message1 = new Message<Text>(text, messageTime, from, to, text.charge());

            } else if (messageType.equalsIgnoreCase("Voice"))
            {
                System.out.println("Voice message duration (secs):");
                String duration = reader.readLine();
                System.out.println("Voice message format:");
                String format = reader.readLine();
                Voice voice = new Voice(Integer.parseInt(duration), format);
                message1 = new Message<Voice>(voice, messageTime, from, to, voice.charge());

            } else if (messageType.equalsIgnoreCase("Media"))
            {
                System.out.println("Media message size (MB)");
                String size = reader.readLine();
                System.out.println("Media message format:");
                String format = reader.readLine();
                Media media = new Media(Double.parseDouble(size), format);
                message1 = new Message<Media>(media, messageTime, from, to, media.charge());
            }
            System.out.println("Message 2:\nMessage type (Text, Voice, Media):");
            messageType = reader.readLine();
            System.out.println("Message time (secs from 1/1/1970):");
            messageTime = Integer.parseInt(reader.readLine());
            System.out.println("Sending number:");
            from = reader.readLine();
            System.out.println("Receiving number:");
            to = reader.readLine();
            if (messageType.equalsIgnoreCase("Text"))
            {
                System.out.println("Text message content");
                String content = reader.readLine();
                Text text = new Text(content);
                message2 = new Message<Text>(text, messageTime, from, to, text.charge());
            } else if (messageType.equalsIgnoreCase("Voice"))
            {
                System.out.println("Voice message duration (secs):");
                String duration = reader.readLine();
                System.out.println("Voice message format:");
                String format = reader.readLine();
                Voice voice = new Voice(Integer.parseInt(duration), format);
                message2 = new Message<Voice>(voice, messageTime, from, to, voice.charge());
            } else if (messageType.equalsIgnoreCase("Media"))
            {
                System.out.println("Media message size (MB)");
                String size = reader.readLine();
                System.out.println("Media message format:");
                String format = reader.readLine();
                Media media = new Media(Double.parseDouble(size), format);

                message2 = new Message<Media>(media, messageTime, from, to, media.charge());
            }

            if (message1 == null || message2 == null)
            {
                System.out.println("Please enter valid Message types");

            } else
            {
                if (message1.equals(message2))
                {
                    System.out.println("Both Messages Are Equal");
                } else
                {
                    System.out.println("The Two Messages Are Not Equal");
                }
            }
        } catch (NumberFormatException e)
        {
            System.out.println("Enter valid Message specifics");
        }
    }

    private void printMenu()
    {
        System.out.println("\nFOOTHILL WIRELESS at " + location + "\nMESSAGE UTILIZATION AND ACCOUNT ADMIN");
        System.out.println("1.) List all accounts");
        System.out.println("2.) Erase the first media message");
        System.out.println("3.) equals test");
        System.out.println("4.) Quit");
    }

    private void quit(BufferedReader reader) throws IOException
    {
        reader.close();
        System.out.println("\t\t\t---END PROGRAM---");
    }

    private void listAccounts()
    {
        String key;
        List<Item> value;
        Item next;
        System.out.println("\nLIST OF ALL ACCOUNTS");
        for (Entry<String, ArrayList<Item>> entry : map.entrySet())
        {
            key = entry.getKey();
            value = entry.getValue();
            double totalCharge = 0;
            System.out.println(key);
            List<Item> mapList = value;
            ListIterator<Item> iterator = mapList.listIterator();
            while (iterator.hasNext())
            {
                next = iterator.next();
                totalCharge += next.getCharge();
                System.out.println(next);
            }
            System.out.format("\t\tCharge:  $%.2f\n", totalCharge);

        }
    }

    private void eraseFirst()
    {
        List<Item> value;
        for (Entry<String, ArrayList<Item>> entry : map.entrySet())
        {
            value = entry.getValue();
            eraseHelper(value);
        }
        System.out.println("Updated Version:");
        listAccounts();
    }

    private void eraseHelper(List<? extends Item> list)
    {
//        for (Item item: list) {
//            if (i instanceof Message<?>) {
//                if(((Message<?>) item).getMessage() instanceof Media){
//                    list.remove(item);
//                    break;
//                }
//            }
//        }

        ListIterator<?> iterator = list.listIterator();
        while (iterator.hasNext())
        {
            Item item = (Item) iterator.next();
            if (item instanceof Message<?>)
            {   
                if (((Message<?>) item).getMessage() instanceof Media)
                {
                    list.remove(item);
                    break;
                }
            }
        }
    }

}

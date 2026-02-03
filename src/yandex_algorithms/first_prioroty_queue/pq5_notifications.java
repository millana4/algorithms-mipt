package yandex_algorithms.prioroty_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class pq5_notifications {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // Количество уведомлений
        int m = Integer.parseInt(st.nextToken()); // Сколько событий вывести

        // PriorityQueue для хранения событий. Сравниваем по времени, потом по id
        PriorityQueue<Event> pq = new PriorityQueue<>((e1, e2) -> {
            if (e1.time != e2.time) {
                return Long.compare(e1.time, e2.time); // Сначала по времени
            }
            return Long.compare(e1.id, e2.id); // При равном времени - по id
        });

        // Читаем все уведомления и добавляем первое событие каждого
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            long id = Long.parseLong(st.nextToken());
            long period = Long.parseLong(st.nextToken());
            long start = Long.parseLong(st.nextToken());

            // Создаем событие для первого срабатывания
            pq.offer(new Event(id, period, start));
        }

        // StringBuilder для эффективного вывода
        StringBuilder sb = new StringBuilder();

        // Выводим m событий
        for (int i = 0; i < m; i++) {
            Event current = pq.poll(); // Берем ближайшее событие

            // Добавляем его id в результат
            sb.append(current.id).append("\n");

            // Планируем следующее срабатывание этого уведомления
            pq.offer(new Event(current.id, current.period, current.time + current.period));
        }

        // Выводим результат
        System.out.print(sb);
    }

    // Класс для представления события (срабатывания уведомления)
    static class Event {
        long id;     // Идентификатор уведомления
        long period; // Период срабатывания
        long time;   // Время, когда должно сработать

        Event(long id, long period, long time) {
            this.id = id;
            this.period = period;
            this.time = time;
        }
    }
}

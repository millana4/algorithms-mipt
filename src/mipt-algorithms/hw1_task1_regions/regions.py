from collections import defaultdict

# Словарь для хранения статистики по регионам
region_stats = defaultdict(list)

with open("input.txt") as file_source:
    lines = file_source.readlines()

    # Пропускаем заголовок
    for line in lines[1:]:
        # Разделяем строку по точкам с запятой
        data = line.strip().split(";")

        # Извлекаем регион и грамотность
        region = data[1]
        literacy = float(data[-1])

        # Добавляем грамотность в список для региона
        region_stats[region].append(literacy)

# Вычисляем долю стран с грамотностью > 90% для каждого региона
region_ratios = {}
for region, literacies in region_stats.items():
    # Количество стран с грамотностью > 90%
    high_literacy_count = sum(1 for lit in literacies if lit > 90)

    # Общее количество стран в регионе
    total_count = len(literacies)

    # Доля стран с высокой грамотностью
    ratio = high_literacy_count / total_count
    region_ratios[region] = ratio

# Находим максимальную долю
max_ratio = max(region_ratios.values())

# Собираем регионы с максимальной долей
top_regions = [region for region, ratio in region_ratios.items() if ratio == max_ratio]

# Сортируем регионы по алфавиту
top_regions.sort()

# Записываем результат в файл
with open("output.txt", "w", encoding="utf-8") as file_destination:
    for region in top_regions:
        file_destination.write(region + '\n')





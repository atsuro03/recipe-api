-- テーブルが重複しないよう存在チェック、あれば削除します
DROP TABLE IF EXISTS recipe;

-- 簡易なレシピテーブル
CREATE TABLE `recipe` (
    `id` bigint unsigned NOT NULL AUTO_INCREMENT,
    `menu` VARCHAR(150) NOT NULL,
    `category` VARCHAR(100) NOT NULL,
    `material` LONGTEXT,
    `step` LONGTEXT, 
    `point` LONGTEXT,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
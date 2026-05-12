# Projeto Neo4j - Jogos antigos

---

## Jogos Cadastrados (Nós)
Generos e jogos implementados:
* **RPGs:** Chrono Trigger, Super Mario RPG
* **Luta:** Street Fighter Alpha 3, Melty Blood AACC, Art of Fighting, Mortal Kombat
* **Beat 'em up:** Final Fight 3, Cadillac & Dinosaurs, Street Rage (Streets of Rage)
* **Plataforma:** Super Mario World, Sonic the Hedgehog, Donkey Kong Country

---

## Relações

Os jogos foram conectados uns aos outros com base em gêneros, similaridades ou franquias. Abaixo estão todas as relações configuradas no sistema:

### Ação
* **Chrono Trigger** -> aponta para **Street Fighter Alpha 3**
* **Chrono Trigger** -> aponta para **Final Fight 3**
* **Final Fight 3** -> aponta para **Cadillac & Dinosaurs**
* **Final Fight 3** -> aponta para **Street Rage**

### Luta
* **Street Fighter Alpha 3** -> aponta para **Final Fight 3** *(que tem elementos de luta de rua)*
* **Street Fighter Alpha 3** -> aponta para **Melty Blood AACC**
* **Street Fighter Alpha 3** -> aponta para **Art of Fighting**
* **Street Fighter Alpha 3** -> aponta para **Mortal Kombat**

### RPG
* **Chrono Trigger** -> aponta para **Super Mario RPG**

### Plataforma
* **Super Mario World** -> aponta para **Sonic the Hedgehog**
* **Super Mario World** -> aponta para **Donkey Kong Country**

### Franquia
* **Super Mario World** -> aponta para **Super Mario RPG**


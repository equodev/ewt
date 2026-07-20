FROM ubuntu:22.04

ENV DEBIAN_FRONTEND=noninteractive

# System dependencies for Flutter Linux desktop builds
RUN apt-get update && apt-get install -y \
    curl \
    git \
    unzip \
    xz-utils \
    zip \
    libglu1-mesa \
    cmake \
    ninja-build \
    pkg-config \
    libgtk-3-dev \
    libwebkit2gtk-4.1-dev \
    clang \
    libblkid-dev \
    liblzma-dev \
    xvfb \
    && rm -rf /var/lib/apt/lists/*

# JDK 22 (Eclipse Temurin 22.0.2+9) — matches the project's minimum runtime (options.release = 22),
# so CI compiles and runs tests on the actual floor. release targeting works on any JDK >= 22.
RUN curl -L "https://github.com/adoptium/temurin22-binaries/releases/download/jdk-22.0.2%2B9/OpenJDK22U-jdk_x64_linux_hotspot_22.0.2_9.tar.gz" \
    | tar xz -C /opt
ENV JAVA_HOME=/opt/jdk-22.0.2+9
ENV PATH="${JAVA_HOME}/bin:${PATH}"

# Flutter SDK (version injected at build time)
ARG FLUTTER_VERSION
RUN curl -L "https://storage.googleapis.com/flutter_infra_release/releases/stable/linux/flutter_linux_${FLUTTER_VERSION}-stable.tar.xz" \
    | tar xJ -C /opt
ENV PATH="/opt/flutter/bin:${PATH}"
# The combined-bundle build sources icudtl.dat from $FLUTTER_ROOT's engine cache; without this
# it falls back to ~/flutter (absent here) and silently ships a bundle that aborts on ICU init.
ENV FLUTTER_ROOT="/opt/flutter"
ENV CXXFLAGS="-std=c++17"

# Flutter refuses to run as root. Create a non-root user, transfer Flutter ownership,
# and run all Flutter setup as that user. CI jobs inherit this user via Kubernetes.
RUN useradd -ms /bin/bash ci \
    && chown -R ci:ci /opt/flutter
USER ci
ENV HOME=/home/ci
RUN git config --global --add safe.directory /opt/flutter \
    && flutter config --enable-linux-desktop \
    && flutter precache --linux
